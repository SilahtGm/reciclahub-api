package br.com.reciclahub.dto;

import java.time.LocalDate;

public record ColetaRequestDTO(
        Long idColeta,
        Long idArmazenamento,
        Long idEmpresa,
        LocalDate dataColeta,
        Double quantidadeColetada
) {
}