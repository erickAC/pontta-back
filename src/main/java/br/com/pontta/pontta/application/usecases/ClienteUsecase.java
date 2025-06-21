package br.com.pontta.pontta.application.usecases;

import java.util.List;

import br.com.pontta.pontta.application.gateways.ClienteGateway;
import br.com.pontta.pontta.domains.entities.Cliente;

public class ClienteUsecase {
    private final ClienteGateway gateway;

    public ClienteUsecase(ClienteGateway gateway) {
        this.gateway = gateway;
    }

    public Cliente salvar(Cliente cliente) {
        return this.gateway.salvar(cliente);
    }

    public Cliente listarById(Integer id) {
        return this.gateway.listarById(id);
    }

    public List<Cliente> listar(String nome) {
        return this.gateway.listar(nome);
    }

    public Cliente alterar(Cliente cliente, Integer id) {
        return this.gateway.alterar(cliente, id);
    }

    public void deletar(Integer id) {
        this.gateway.deletar(id);
    }

}
