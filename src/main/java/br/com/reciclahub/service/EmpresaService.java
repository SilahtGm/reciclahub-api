package br.com.reciclahub.service;

import br.com.reciclahub.dto.EmpresaRequestDTO;
import br.com.reciclahub.dto.EmpresaResponseDTO;
import br.com.reciclahub.model.Empresa;
import br.com.reciclahub.repository.EmpresaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

@Service
public class EmpresaService {

    private final EmpresaRepository empresaRepository;
    private final PasswordEncoder passwordEncoder;

    public EmpresaService(EmpresaRepository empresaRepository, PasswordEncoder passwordEncoder) {
        this.empresaRepository = empresaRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public EmpresaResponseDTO cadastrarEmpresa(EmpresaRequestDTO empresaRequestDTO) {
        if (empresaRepository.existsByEmail(empresaRequestDTO.email())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Já existe uma empresa cadastrada com este e-mail");
        }
        if (empresaRepository.existsByCnpj(empresaRequestDTO.cnpj())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Já existe uma empresa cadastrada com este CNPJ");
        }

        Empresa empresa = new Empresa();
        BeanUtils.copyProperties(empresaRequestDTO, empresa);
        empresa.setSenha(passwordEncoder.encode(empresaRequestDTO.senha()));

        Empresa empresaSalva = empresaRepository.save(empresa);
        return new EmpresaResponseDTO(empresaSalva);
    }
}
