package br.com.reciclahub.controller;

import br.com.reciclahub.dto.ArmazenamentoRequestDTO;
import br.com.reciclahub.dto.ArmazenamentoResponseDTO;
import br.com.reciclahub.model.Armazenamento;
import br.com.reciclahub.service.ArmazenamentoService;
import jakarta.validation.Valid;
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
    @ResponseStatus(HttpStatus.CREATED)
    public ArmazenamentoResponseDTO salvar(@Valid @RequestBody ArmazenamentoRequestDTO armazenamentoDTO) {
            return armazenamentoService.salvarArmazenamento(armazenamentoDTO);
    }

    @GetMapping("/armazenamentos/{id}")
    public ResponseEntity<List<ArmazenamentoResponseDTO>> listarArmazenamentosPorPonto(@PathVariable Long id) {
        try { return ResponseEntity.ok(armazenamentoService.listarTodosPorId(id)); }
        catch (Exception e) {
           return ResponseEntity.notFound().build();
        }
    }

    @PutMapping ("/armazenamentos")
    public ResponseEntity<ArmazenamentoResponseDTO> atualizar(@Valid @RequestBody ArmazenamentoRequestDTO armazenamentoDTO) {
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

    @GetMapping("/armazenamentos")
    public ResponseEntity<List<ArmazenamentoResponseDTO>> listarTodos() {
        try {
            return ResponseEntity.ok(armazenamentoService.listarTodos());
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

}