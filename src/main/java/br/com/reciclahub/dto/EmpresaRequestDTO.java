package br.com.reciclahub.dto;

public record EmpresaRequestDTO(
        String cnpj,
        String nome,
        String email,
        String senha,
        String tipo
) {
}