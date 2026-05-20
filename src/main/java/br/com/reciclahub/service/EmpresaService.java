package br.com.reciclahub.service;

import br.com.reciclahub.dto.EmpresaRequestDTO;
import br.com.reciclahub.dto.EmpresaResponseDTO;
import br.com.reciclahub.model.Empresa;
import br.com.reciclahub.repository.EmpresaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    public EmpresaResponseDTO cadastrarEmpresa(EmpresaRequestDTO empresaRequestDTO) {
        Empresa empresa = new Empresa();
        BeanUtils.copyProperties(empresaRequestDTO, empresa); // criando objeto empresa (model)
        // com tudo que recebemos de empresaDTO copiando
        // e passando de empresaDTO para empresa
        Empresa empresaSalva = empresaRepository.save(empresa);
        return new EmpresaResponseDTO(empresaSalva);
    }
}
