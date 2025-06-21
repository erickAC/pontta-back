package br.com.pontta.pontta.domains.requests;

import jakarta.validation.constraints.NotNull;

public record CriarClienteRequest(
    @NotNull String nome,
    @NotNull String email,
    @NotNull String cpf
) {
    
}
