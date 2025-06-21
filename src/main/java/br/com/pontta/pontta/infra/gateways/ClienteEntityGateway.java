package br.com.pontta.pontta.infra.gateways;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.pontta.pontta.application.gateways.ClienteGateway;
import br.com.pontta.pontta.domains.entities.Cliente;
import br.com.pontta.pontta.infra.persistence.entities.ClienteEntityJpa;
import br.com.pontta.pontta.infra.persistence.mappers.ClienteEntityMapper;
import br.com.pontta.pontta.infra.persistence.repositories.ClienteEntityJpaRepository;

@Service
public class ClienteEntityGateway implements ClienteGateway {

    private final ClienteEntityJpaRepository repository;
    private final ClienteEntityMapper mapper;

    public ClienteEntityGateway(ClienteEntityJpaRepository repository, ClienteEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Cliente salvar(Cliente cliente) {
        ClienteEntityJpa entityJpa = this.repository.save(this.mapper.toEntity(cliente));
        return this.mapper.toDomain(entityJpa);
    }

    @Override
    public Cliente alterar(Cliente cliente, Integer id) {
        ClienteEntityJpa entityJpa = findById(id);
        cliente.setId(entityJpa.getId());
        entityJpa = this.repository.save(this.mapper.toEntity(cliente));
        return this.mapper.toDomain(entityJpa);
    }

    @Override
    public void deletar(Integer id) {
        this.repository.delete(findById(id));
    }

    @Override
    public List<Cliente> listar(String nome) {
        if (nome == null || nome.isEmpty()) return this.repository.findAll().stream().map(this.mapper::toDomain).toList();
        return this.repository.findAllByNomeContaining(nome).stream().map(mapper::toDomain).toList();
    }

    private ClienteEntityJpa findById(Integer id) {
        return this.repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario nao encontrado!"));
    }

    @Override
    public Cliente listarById(Integer id) {
        return this.mapper.toDomain(findById(id));
    }

}
