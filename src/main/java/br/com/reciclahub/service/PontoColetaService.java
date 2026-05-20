package br.com.reciclahub.service;

import br.com.reciclahub.dto.PontoColetaRequestDTO;
import br.com.reciclahub.dto.PontoColetaResponseDTO;
import br.com.reciclahub.dto.TipoResiduoResponseDTO;
import br.com.reciclahub.model.PontoColeta;
import br.com.reciclahub.repository.PontoColetaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PontoColetaService {

    @Autowired
    private PontoColetaRepository pontoColetaRepository;

    public PontoColetaResponseDTO salvar(PontoColetaRequestDTO pontoColetaRequestDTO) {
        PontoColeta ponto = new PontoColeta();
        BeanUtils.copyProperties(pontoColetaRequestDTO, ponto);
        PontoColeta pontoSalvo = pontoColetaRepository.save(ponto);
        return new PontoColetaResponseDTO(pontoSalvo);
    }

    public PontoColetaResponseDTO buscarPorId(Long id) {
        Optional<PontoColeta> pontoColetaOptional = pontoColetaRepository.findById(id);
        if (pontoColetaOptional.isPresent()) {
            return new PontoColetaResponseDTO(pontoColetaOptional.get());
        } else {
            throw new RuntimeException("Ponto não encontrado.");
        }
    }

    public List<PontoColetaResponseDTO> listarTodos() {
        return pontoColetaRepository.findAll()
                .stream()
                .map(PontoColetaResponseDTO::new)
                .toList();
    }

    public void exluir(Long id) {
        Optional<PontoColeta> pontoColetaOptional = pontoColetaRepository.findById(id);
        if (pontoColetaOptional.isPresent()){
            pontoColetaRepository.deleteById(id);
        } else {
            throw new RuntimeException("Ponto não encontrado");
        }
    }

    public PontoColeta atualizar(PontoColeta pontoColeta) {
        Optional<PontoColeta> pontoColetaOptional = pontoColetaRepository.findById(pontoColeta.getId());
        if (pontoColetaOptional.isPresent()) {
            return pontoColetaRepository.save(pontoColeta);
        } else {
            throw new RuntimeException("Ponto não encontrado.");
        }
    }
}
