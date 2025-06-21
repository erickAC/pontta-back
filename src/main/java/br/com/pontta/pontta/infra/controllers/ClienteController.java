package br.com.pontta.pontta.infra.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.pontta.pontta.application.usecases.ClienteUsecase;
import br.com.pontta.pontta.domains.entities.Cliente;
import br.com.pontta.pontta.domains.requests.CriarClienteRequest;
import br.com.pontta.pontta.infra.persistence.mappers.ClienteEntityMapper;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/clientes")
@CrossOrigin("*")
public class ClienteController {
    private final ClienteUsecase usecase;
    private final ClienteEntityMapper mapper;

    public ClienteController(ClienteUsecase usecase, ClienteEntityMapper mapper) {
        this.usecase = usecase;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<Cliente> salvar(@Valid @RequestBody CriarClienteRequest request) {
        Cliente cliente = this.usecase.salvar(this.mapper.requestToDomain(request));
        return ResponseEntity.created(UriComponentsBuilder.fromPath("/clientes/{id}").queryParam("id", cliente.getId()).build().toUri()).body(cliente);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(this.usecase.listarById(id));
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> listar(@RequestParam(required = false) String nome) {
        return ResponseEntity.ok().body(this.usecase.listar(nome));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> alterar(@Valid @RequestBody CriarClienteRequest request, @PathVariable Integer id) {
        Cliente cliente = this.usecase.alterar(this.mapper.requestToDomain(request), id);
        return ResponseEntity.ok().body(cliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        this.usecase.deletar(id);
        return ResponseEntity.ok().build();
    }
    
}
