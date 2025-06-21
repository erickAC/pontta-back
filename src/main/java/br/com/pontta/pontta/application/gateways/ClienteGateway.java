package br.com.pontta.pontta.application.gateways;

import java.util.List;

import br.com.pontta.pontta.domains.entities.Cliente;

public interface ClienteGateway {
    public Cliente salvar(Cliente cliente);
    public Cliente listarById(Integer id);
    public Cliente alterar(Cliente cliente, Integer id);
    public List<Cliente> listar(String nome);
    public void deletar(Integer id);
}
