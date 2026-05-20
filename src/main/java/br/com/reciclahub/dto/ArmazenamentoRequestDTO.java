package br.com.reciclahub.dto;

public record ArmazenamentoRequestDTO(
        Long idPontoColeta,
        Long idTipoResiduo,
        Double quantidadeAtual
) {
}