package br.com.pontta.pontta.infra.persistence.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pontta.pontta.infra.persistence.entities.ClienteEntityJpa;

public interface ClienteEntityJpaRepository extends JpaRepository<ClienteEntityJpa, Integer> {
    
    List<ClienteEntityJpa> findAllByNomeContaining(String nome);

}
