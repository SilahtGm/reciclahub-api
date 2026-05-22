package br.com.reciclahub.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record TipoResiduoRequestDTO(
        @NotBlank(message = "Nome é obrigatório")
        @Size(max = 100, message = "Nome deve ter no máximo 100 caracteres")
        String nome,

        @Size(max = 500, message = "Descrição deve ter no máximo 500 caracteres")
        String descricao,

        @NotNull(message = "Limite máximo é obrigatório")
        @Positive(message = "Limite máximo deve ser maior que zero")
        Integer limiteMaximo
) {}