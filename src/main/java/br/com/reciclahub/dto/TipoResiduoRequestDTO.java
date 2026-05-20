package br.com.reciclahub.dto;

public record TipoResiduoRequestDTO(
        String nome,
        String descricao,
        Integer limiteMaximo
) {
}