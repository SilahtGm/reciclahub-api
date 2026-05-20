package br.com.reciclahub.dto;

public record PontoColetaRequestDTO(
        String nomeLocal,
        String endereco,
        Integer capacidadeTotal,
        Long idEmpresa
) {
}