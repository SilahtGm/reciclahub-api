package br.com.reciclahub.controller;

import br.com.reciclahub.dto.ArmazenamentoRequestDTO;
import br.com.reciclahub.dto.ArmazenamentoResponseDTO;
import br.com.reciclahub.model.Armazenamento;
import br.com.reciclahub.service.ArmazenamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ArmazenamentoController {

    @Autowired
    private ArmazenamentoService armazenamentoService;

    @PostMapping ("/armazenamentos")
    public ResponseEntity<ArmazenamentoResponseDTO> salvar(@RequestBody ArmazenamentoRequestDTO armazenamentoDTO) {
        try {
            return ResponseEntity.ok(armazenamentoService.salvarArmazenamento(armazenamentoDTO));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/ponto/{id}")
    public ResponseEntity<List<ArmazenamentoResponseDTO>> listarArmazenamentosPorPonto(@PathVariable Long id) {
        try { return ResponseEntity.ok(armazenamentoService.listarTodosPorId(id)); }
        catch (Exception e) {
           return ResponseEntity.notFound().build();
        }
    }

    @PutMapping ("/armazenamentos/{id}")
    public ResponseEntity<ArmazenamentoResponseDTO> atualizar(@RequestBody ArmazenamentoRequestDTO armazenamentoDTO) {
        try {
            return ResponseEntity.ok(armazenamentoService.atualizar(armazenamentoDTO));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/armazenamentos/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir (@PathVariable Long id) {
        armazenamentoService.excluir(id);
    }

}