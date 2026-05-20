package br.com.reciclahub.dto;

import br.com.reciclahub.model.Coleta;

import java.time.LocalDate;

public record ColetaResponseDTO(
        Long idColeta,
        Long idArmazenamento,
        Long idEmpresa,
        LocalDate dataColeta,
        Double quantidadeColetada
) {

    public ColetaResponseDTO(Coleta coleta) {
        this(
                coleta.getIdColeta(),
                coleta.getArmazenamento().getIdArmazenamento(),
                coleta.getEmpresa().getIdEmpresa(),
                coleta.getDataColeta(),
                coleta.getQuantidadeColetada()
        );
    }
}