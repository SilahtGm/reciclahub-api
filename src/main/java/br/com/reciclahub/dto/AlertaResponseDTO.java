package br.com.reciclahub.dto;

import br.com.reciclahub.model.Alerta;

import java.time.LocalDate;

public record AlertaResponseDTO(
        Long idAlerta,
        Long idArmazenamento,
        Long idEmpresa,
        String descricao,
        LocalDate dataAlerta,
        String status
) {

    public AlertaResponseDTO(Alerta alerta) {
        this(
                alerta.getIdAlerta(),
                alerta.getArmazenamento().getIdArmazenamento(),
                alerta.getEmpresa().getIdEmpresa(),
                alerta.getDescricao(),
                alerta.getDataAlerta(),
                alerta.getStatus()
        );
    }
}