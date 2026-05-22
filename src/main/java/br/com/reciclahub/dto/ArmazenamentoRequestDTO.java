package br.com.reciclahub.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public record ArmazenamentoRequestDTO(
        Long idArmazenamento,

        @NotNull(message = "Ponto de coleta é obrigatório")
        Long pontoColeta,

        @NotNull(message = "Tipo de resíduo é obrigatório")
        Long tipoResiduo,

        @PositiveOrZero(message = "Quantidade atual não pode ser negativa")
        Double quantidadeAtual
) {}