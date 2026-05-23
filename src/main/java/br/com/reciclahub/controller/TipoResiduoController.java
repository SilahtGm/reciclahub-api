package br.com.reciclahub.controller;

import br.com.reciclahub.dto.TipoResiduoRequestDTO;
import br.com.reciclahub.dto.TipoResiduoResponseDTO;
import br.com.reciclahub.service.TipoResiduoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TipoResiduoController {

    @Autowired
    private TipoResiduoService tipoResiduoService;


    @GetMapping ("/tipo-coleta")
    public ResponseEntity<List<TipoResiduoResponseDTO>> listarTodos() {
        try { return ResponseEntity.ok(tipoResiduoService.listarTodos());
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping("/tipo-coleta")
    @ResponseStatus(HttpStatus.CREATED)
    public TipoResiduoResponseDTO salvar(@Valid @RequestBody TipoResiduoRequestDTO tipoResiduoRequestDTO) {
        return tipoResiduoService.salvar(tipoResiduoRequestDTO);
    }

    @GetMapping("tipo-coleta/{id}")
    public ResponseEntity<TipoResiduoResponseDTO> buscarPorId(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(tipoResiduoService.EncontrarPorId(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/tipo-coleta/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        try {
            tipoResiduoService.excluir(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}