package br.com.reciclahub.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

public record ColetaRequestDTO(
        Long idColeta,

        @NotNull(message = "ID do armazenamento é obrigatório")
        Long idArmazenamento,

        @NotNull(message = "ID da empresa é obrigatório")
        Long idEmpresa,

        @NotNull(message = "Data da coleta é obrigatória")
        @PastOrPresent(message = "Data da coleta não pode ser futura")
        LocalDate dataColeta,

        @NotNull(message = "Quantidade coletada é obrigatória")
        @Positive(message = "Quantidade coletada deve ser maior que zero")
        Double quantidadeColetada
) {}