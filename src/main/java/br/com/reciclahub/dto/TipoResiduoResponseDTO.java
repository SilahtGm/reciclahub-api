package br.com.reciclahub.dto;

import br.com.reciclahub.model.TipoResiduo;

public record TipoResiduoResponseDTO(
        Long id,
        String nome,
        String descricao,
        Integer limiteMaximo
) {

    public TipoResiduoResponseDTO(TipoResiduo tipoResiduo) {
        this(
                tipoResiduo.getId(),
                tipoResiduo.getNome(),
                tipoResiduo.getDescricao(),
                tipoResiduo.getLimiteMaximo()
        );
    }
}