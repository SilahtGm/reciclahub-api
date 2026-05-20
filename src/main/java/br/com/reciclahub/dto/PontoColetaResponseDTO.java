package br.com.reciclahub.dto;

import br.com.reciclahub.model.PontoColeta;

public record PontoColetaResponseDTO(
        Long id,
        String nomeLocal,
        String endereco,
        Integer capacidadeTotal,
        Long idEmpresa
) {

    public PontoColetaResponseDTO(PontoColeta pontoColeta) {
        this(
                pontoColeta.getId(),
                pontoColeta.getNomeLocal(),
                pontoColeta.getEndereco(),
                pontoColeta.getCapacidadeTotal(),
                pontoColeta.getEmpresa().getIdEmpresa()
        );
    }
}