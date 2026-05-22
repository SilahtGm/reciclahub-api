package br.com.reciclahub.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record EmpresaRequestDTO(
        @NotBlank(message = "CNPJ é obrigatório")
        @Pattern(regexp = "\\d{14}", message = "CNPJ deve conter 14 dígitos numéricos")
        String cnpj,

        @NotBlank(message = "Nome é obrigatório")
        @Size(max = 100, message = "Nome deve ter no máximo 100 caracteres")
        String nome,

        @NotBlank(message = "E-mail é obrigatório")
        @Email(message = "E-mail inválido")
        String email,

        @NotBlank(message = "Senha é obrigatória")
        @Size(min = 8, message = "Senha deve ter no mínimo 8 caracteres")
        String senha,

        @NotBlank(message = "Tipo é obrigatório")
        String tipo
) {}