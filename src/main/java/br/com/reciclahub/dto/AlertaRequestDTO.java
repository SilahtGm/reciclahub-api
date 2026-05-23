package br.com.reciclahub.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record AlertaRequestDTO(
        @NotNull(message = "ID do armazenamento é obrigatório")
        Long idArmazenamento,

        @NotNull(message = "ID da empresa é obrigatório")
        Long idEmpresa,

        @NotBlank(message = "Descrição é obrigatória")
        @Size(max = 255, message = "Descrição deve ter no máximo 255 caracteres")
        String descricao,

        @NotNull(message = "Data do alerta é obrigatória")
        LocalDate dataAlerta,

        @NotBlank(message = "Status é obrigatório")
        @Size(max = 50, message = "Status deve ter no máximo 50 caracteres")
        String status
) {
}
