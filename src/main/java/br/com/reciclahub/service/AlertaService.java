package br.com.reciclahub.service;

import br.com.reciclahub.model.Alerta;
import br.com.reciclahub.model.Coleta;
import br.com.reciclahub.repository.AlertaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlertaService {

    @Autowired
    AlertaRepository alertaRepository;

    public List<Alerta> listarPorEmpresa (Long id) { return alertaRepository.findByEmpresaIdEmpresa(id); }


}
