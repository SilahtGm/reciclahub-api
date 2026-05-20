package br.com.reciclahub.controller;

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
    @ResponseStatus(HttpStatus.CREATED)

    public Armazenamento salvar(@RequestBody Armazenamento armazenamento) {
        return armazenamentoService.salvarArmazenamento(armazenamento);
    }

    @GetMapping("/ponto/{id}")
    public ResponseEntity<List<ArmazenamentoResponseDTO>> listarArmazenamentosPorPonto(@PathVariable Long id) {
        try { return ResponseEntity.ok(armazenamentoService.listarTodosPorId(id)); }
        catch (Exception e) {
           return ResponseEntity.notFound().build();
        }
    }

    @PutMapping ("/armazenamentos")
    @ResponseStatus(HttpStatus.OK)
    public Armazenamento atualizar(@RequestBody Armazenamento armazenamento) {
        return armazenamentoService.atualizar(armazenamento);
    }

    @DeleteMapping("/armazenamentos/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir (@PathVariable Long id) {
        armazenamentoService.exluir(id);
    }

}