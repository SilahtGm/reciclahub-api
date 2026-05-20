package br.com.reciclahub.dto;

import br.com.reciclahub.model.Armazenamento;

public record ArmazenamentoResponseDTO(
        Long idArmazenamento,
        Long idPontoColeta,
        Long idTipoResiduo,
        Double quantidadeAtual
) {

    public ArmazenamentoResponseDTO(Armazenamento armazenamento) {
        this(
                armazenamento.getIdArmazenamento(),
                armazenamento.getPontoColeta().getId(),
                armazenamento.getTipoResiduo().getId(),
                armazenamento.getQuantidadeAtual()
        );
    }
}