package br.com.reciclahub.controller;

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
    @ResponseStatus(HttpStatus.OK)
    public List<Alerta> listarPorEmpresa(@PathVariable Long idEmpresa) {
        return alertaService.listarPorEmpresa(idEmpresa);
    }
}