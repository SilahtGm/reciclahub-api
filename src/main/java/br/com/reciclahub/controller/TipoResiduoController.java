package br.com.reciclahub.controller;

import br.com.reciclahub.dto.TipoResiduoResponseDTO;
import br.com.reciclahub.service.TipoResiduoService;
import org.springframework.beans.factory.annotation.Autowired;
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


    @GetMapping("tipo-coleta/{id}")
    public ResponseEntity<TipoResiduoResponseDTO> buscarPorId(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(tipoResiduoService.EncontrarPorId(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}