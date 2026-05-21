package br.com.reciclahub.dto;

public record ArmazenamentoRequestDTO(
        Long idArmazenamento,
        Long pontoColeta,
        Long tipoResiduo,
        Double quantidadeAtual
) {
}