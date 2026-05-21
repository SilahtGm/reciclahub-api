package br.com.reciclahub.dto;

public record PontoColetaRequestDTO(
        Long idPontoColeta,
        String nomeLocal,
        String endereco,
        Integer capacidadeTotal,
        Long idEmpresa
) {
}