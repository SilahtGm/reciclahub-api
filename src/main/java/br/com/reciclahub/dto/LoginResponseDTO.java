package br.com.reciclahub.dto;

public record LoginResponseDTO(
        String token,
        String tipoToken,
        long expiracaoMs,
        Long idEmpresa,
        String nome,
        String email,
        String tipo
) {}
