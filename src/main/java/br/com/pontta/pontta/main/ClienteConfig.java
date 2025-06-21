package br.com.pontta.pontta.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.pontta.pontta.application.gateways.ClienteGateway;
import br.com.pontta.pontta.application.usecases.ClienteUsecase;
import br.com.pontta.pontta.infra.gateways.ClienteEntityGateway;
import br.com.pontta.pontta.infra.persistence.mappers.ClienteEntityMapper;
import br.com.pontta.pontta.infra.persistence.repositories.ClienteEntityJpaRepository;

@Configuration
public class ClienteConfig {
    
    @Bean
    public ClienteEntityMapper clienteEntityMapper() {
        return new ClienteEntityMapper();
    }

    @Bean
    public ClienteUsecase clienteUsecase(ClienteGateway clienteGateway) {
        return new ClienteUsecase(clienteGateway);
    }

    @Bean
    public ClienteGateway clienteGateway(ClienteEntityJpaRepository repository, ClienteEntityMapper mapper) {
        return new ClienteEntityGateway(repository, mapper);
    }

}
