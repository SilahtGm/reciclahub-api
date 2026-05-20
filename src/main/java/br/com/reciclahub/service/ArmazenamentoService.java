package br.com.reciclahub.service;

import br.com.reciclahub.dto.ArmazenamentoResponseDTO;
import br.com.reciclahub.model.Armazenamento;
import br.com.reciclahub.model.Coleta;
import br.com.reciclahub.model.PontoColeta;
import br.com.reciclahub.repository.ArmazenamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArmazenamentoService {

    @Autowired
    ArmazenamentoRepository armazenamentoRepository;

    public Armazenamento salvarArmazenamento (Armazenamento armazenamento) {
        return armazenamentoRepository.save(armazenamento);
    }

    public List<ArmazenamentoResponseDTO> listarTodosPorId (Long id) {
        return armazenamentoRepository.findByPontoColetaId(id).stream()
                .map(ArmazenamentoResponseDTO::new)
                .toList();
    }

    public Armazenamento atualizar(Armazenamento armazenamento) {
        Optional<Armazenamento> armazenamentoOptional = armazenamentoRepository.findById(armazenamento.getIdArmazenamento());
        if (armazenamentoOptional.isPresent()) {
            return armazenamentoRepository.save(armazenamento);
        } else {
            throw new RuntimeException("Armazenamento não encontrado.");
        }
    }

    public void exluir(Long id) {
        Optional<Armazenamento> armazenamentoOptional = armazenamentoRepository.findById(id);
        if (armazenamentoOptional.isPresent()){
            armazenamentoRepository.deleteById(id);
        } else {
            throw new RuntimeException("armazenamento não encontrado");
        }
    }
}
