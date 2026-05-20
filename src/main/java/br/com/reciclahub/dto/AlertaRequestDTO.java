package br.com.reciclahub.dto;

import java.time.LocalDate;

public record AlertaRequestDTO(
        Long idArmazenamento,
        Long idEmpresa,
        String descricao,
        LocalDate dataAlerta,
        String status
) {
}