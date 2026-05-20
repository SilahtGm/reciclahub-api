package br.com.reciclahub.controller;

import br.com.reciclahub.dto.AlertaResponseDTO;
import br.com.reciclahub.model.Alerta;
import br.com.reciclahub.service.AlertaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AlertaController {

    @Autowired
    private AlertaService alertaService;

    @GetMapping("/alertas/{idEmpresa}")
    public ResponseEntity<List<AlertaResponseDTO>> listarPorEmpresa(@PathVariable Long idEmpresa) {
        try {
            return ResponseEntity.ok(alertaService.listarPorEmpresa(idEmpresa));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

}