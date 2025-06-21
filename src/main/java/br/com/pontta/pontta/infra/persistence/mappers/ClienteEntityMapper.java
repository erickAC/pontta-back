package br.com.pontta.pontta.infra.persistence.mappers;

import org.springframework.stereotype.Component;

import br.com.pontta.pontta.domains.entities.Cliente;
import br.com.pontta.pontta.domains.requests.CriarClienteRequest;
import br.com.pontta.pontta.infra.persistence.entities.ClienteEntityJpa;

@Component
public class ClienteEntityMapper {
    
    public ClienteEntityJpa toEntity(Cliente cliente) {
        ClienteEntityJpa entityJpa = new ClienteEntityJpa();
        entityJpa.setCpf(cliente.getCpf());
        entityJpa.setEmail(cliente.getEmail());
        entityJpa.setNome(cliente.getNome());
        entityJpa.setId(cliente.getId());
        return entityJpa;
    }

    public Cliente toDomain(ClienteEntityJpa entityJpa) {
        Cliente cliente = new Cliente();
        cliente.setCpf(entityJpa.getCpf());
        cliente.setEmail(entityJpa.getEmail());
        cliente.setNome(entityJpa.getNome());
        cliente.setId(entityJpa.getId());
        return cliente;
    }

    public Cliente requestToDomain(CriarClienteRequest request) {
        Cliente cliente = new Cliente();
        cliente.setCpf(request.cpf());
        cliente.setEmail(request.email());
        cliente.setNome(request.nome());
        return cliente;
    }

    public ClienteEntityJpa requestToEntity(CriarClienteRequest request) {
        ClienteEntityJpa entityJpa = new ClienteEntityJpa();
        entityJpa.setCpf(request.cpf());
        entityJpa.setEmail(request.email());
        entityJpa.setNome(request.nome());
        return entityJpa;
    }

}
