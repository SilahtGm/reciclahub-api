package br.com.reciclahub.controller;

import br.com.reciclahub.dto.EmpresaRequestDTO;
import br.com.reciclahub.dto.EmpresaResponseDTO;
import br.com.reciclahub.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/api")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @RequestMapping ("/cadastro/empresa")
    @ResponseStatus(HttpStatus.CREATED)
    public EmpresaResponseDTO salvar(@RequestBody EmpresaRequestDTO empresaRequestDTO) {
        return empresaService.cadastrarEmpresa(empresaRequestDTO);
    }
}
