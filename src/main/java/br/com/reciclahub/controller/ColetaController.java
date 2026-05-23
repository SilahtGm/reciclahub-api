package br.com.reciclahub.controller;

import br.com.reciclahub.dto.ColetaRequestDTO;
import br.com.reciclahub.dto.ColetaResponseDTO;
import br.com.reciclahub.model.Coleta;
import br.com.reciclahub.service.ColetaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ColetaController {

    @Autowired
    private ColetaService coletaService;

    @PostMapping ("/coletas")
    @ResponseStatus(HttpStatus.CREATED)
    public ColetaResponseDTO salvar(@Valid @RequestBody ColetaRequestDTO coletaRequestDTO) {
        return coletaService.salvar(coletaRequestDTO);
    }

    @GetMapping("/coletas/{idEmpresa}")
    @ResponseStatus(HttpStatus.OK)
    public List<ColetaResponseDTO> listarPorEmpresa(@PathVariable Long idEmpresa) {
        return coletaService.listarPorEmpresa(idEmpresa);
    }

    @PutMapping("/coletas")
    public ResponseEntity<ColetaResponseDTO> atualizar(@Valid @RequestBody ColetaRequestDTO coletaDTO) {
        try { return ResponseEntity.ok(coletaService.atualizar(coletaDTO));
        } catch (Exception e) {
                return ResponseEntity.notFound().build();
            }

    }

    @DeleteMapping("/coletas/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir (@PathVariable Long id) {
        coletaService.excluir(id);
    }

    @GetMapping("/coletas")
    public ResponseEntity<List<ColetaResponseDTO>> listarTodos() {
        try {
            return ResponseEntity.ok(coletaService.listarTodos());
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

}