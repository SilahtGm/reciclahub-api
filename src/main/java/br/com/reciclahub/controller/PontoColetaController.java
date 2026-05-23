package br.com.reciclahub.controller;

import br.com.reciclahub.dto.PontoColetaRequestDTO;
import br.com.reciclahub.dto.PontoColetaResponseDTO;
import br.com.reciclahub.model.PontoColeta;
import br.com.reciclahub.service.PontoColetaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PontoColetaController {

    @Autowired
    private PontoColetaService pontoColetaService;

    @GetMapping("/ponto-coleta/{id}")
    public ResponseEntity<PontoColetaResponseDTO> buscarPorId(@PathVariable Long id) {
        try { return ResponseEntity.ok(pontoColetaService.buscarPorId(id)); }
        catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

@GetMapping("/ponto-coleta")
public ResponseEntity<List<PontoColetaResponseDTO>> listarTodos() {
        try { return ResponseEntity.ok(pontoColetaService
                .listarTodos());}
        catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
}

@PostMapping("/ponto-coleta")
@ResponseStatus(HttpStatus.CREATED)
    public PontoColetaResponseDTO salvar(@Valid @RequestBody PontoColetaRequestDTO pontoColetaRequestDTO) {
    return pontoColetaService.salvar(pontoColetaRequestDTO);
}

@DeleteMapping("/ponto-coleta/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir (@PathVariable Long id) {
    pontoColetaService.excluir(id);
}

@PutMapping ("/ponto-coleta")
    public ResponseEntity<PontoColetaResponseDTO> atualizar(@Valid @RequestBody PontoColetaRequestDTO pontoColetaDTO) {
    try { return ResponseEntity.ok(pontoColetaService.atualizar(pontoColetaDTO));
    } catch (Exception e) {
        return ResponseEntity.notFound().build();
    }
}

}
