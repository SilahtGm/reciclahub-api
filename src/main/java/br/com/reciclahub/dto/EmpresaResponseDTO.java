package br.com.reciclahub.dto;

import br.com.reciclahub.model.Empresa;

public record EmpresaResponseDTO(
        Long idEmpresa,
        String cnpj,
        String nome,
        String tipo
) {

    public EmpresaResponseDTO(Empresa empresa) {
        this(
                empresa.getIdEmpresa(),
                empresa.getCnpj(),
                empresa.getNome(),
                empresa.getTipo()
        );
    }
}