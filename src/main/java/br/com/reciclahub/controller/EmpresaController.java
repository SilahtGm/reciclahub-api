package br.com.reciclahub.controller;

import br.com.reciclahub.dto.EmpresaRequestDTO;
import br.com.reciclahub.dto.EmpresaResponseDTO;
import br.com.reciclahub.service.EmpresaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/api")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @PostMapping("/cadastro/empresa")
    @ResponseStatus(HttpStatus.CREATED)
    public EmpresaResponseDTO salvar(@Valid @RequestBody EmpresaRequestDTO empresaRequestDTO) {
        return empresaService.cadastrarEmpresa(empresaRequestDTO);
    }
}
