package br.com.silva.appCompra.controller;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * DTO (Data Transfer Object) usado para transferência de dados na criação de um cliente.
 * Utiliza o recurso `record` para facilitar a imutabilidade e geração automática de métodos.
 */
public record CreateClienteDto(

        @NotBlank(message = "Nome não pode estar vazio") // Garante que o nome não seja nulo nem vazio
        String nome,

        @Email(message = "E-mail inválido") // Valida se o formato do e-mail está correto
        @NotBlank(message = "E-mail é obrigatório") // Garante que o e-mail não esteja em branco
        String email,

        @Size(min = 6, message = "A senha deve ter pelo menos 6 caracteres") // Define um tamanho mínimo para a senha
        String senha

) {
}
