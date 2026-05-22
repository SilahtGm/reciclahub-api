package br.com.reciclahub.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record PontoColetaRequestDTO(
        Long idPontoColeta,

        @NotBlank(message = "Nome do local é obrigatório")
        @Size(max = 100, message = "Nome do local deve ter no máximo 100 caracteres")
        String nomeLocal,

        @NotBlank(message = "Endereço é obrigatório")
        @Size(max = 200, message = "Endereço deve ter no máximo 200 caracteres")
        String endereco,

        @NotNull(message = "Capacidade total é obrigatória")
        @Positive(message = "Capacidade total deve ser maior que zero")
        Integer capacidadeTotal,

        @NotNull(message = "ID da empresa é obrigatório")
        Long idEmpresa
) {}