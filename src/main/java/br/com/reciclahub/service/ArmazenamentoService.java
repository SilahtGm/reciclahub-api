package br.com.reciclahub.service;

import br.com.reciclahub.dto.ArmazenamentoRequestDTO;
import br.com.reciclahub.dto.ArmazenamentoResponseDTO;
import br.com.reciclahub.model.Armazenamento;
import br.com.reciclahub.model.Coleta;
import br.com.reciclahub.model.PontoColeta;
import br.com.reciclahub.repository.ArmazenamentoRepository;
import br.com.reciclahub.repository.PontoColetaRepository;
import br.com.reciclahub.repository.TipoResiduoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArmazenamentoService {

    @Autowired
    ArmazenamentoRepository armazenamentoRepository;

    @Autowired
    PontoColetaRepository pontoColetaRepository;

    @Autowired
    TipoResiduoRepository tipoResiduoRepository;

    public ArmazenamentoResponseDTO salvarArmazenamento (ArmazenamentoRequestDTO armazenamentoDTO) {
        Armazenamento armazenamento = new Armazenamento();
        BeanUtils.copyProperties(armazenamentoDTO, armazenamento);
        armazenamento.setPontoColeta(pontoColetaRepository.getReferenceById(armazenamentoDTO.pontoColeta()));
        armazenamento.setTipoResiduo(tipoResiduoRepository.getReferenceById(armazenamentoDTO.tipoResiduo()));
        Armazenamento armazenamentoSalvo = armazenamentoRepository.save(armazenamento);
        return new ArmazenamentoResponseDTO(armazenamentoSalvo);
    }

    public List<ArmazenamentoResponseDTO> listarTodos() {
        return armazenamentoRepository.findAll()
                .stream()
                .map(ArmazenamentoResponseDTO::new)
                .toList();
    }

    public List<ArmazenamentoResponseDTO> listarTodosPorId (Long id) {
        return armazenamentoRepository.findByPontoColetaIdPontoColeta(id).stream()
                .map(ArmazenamentoResponseDTO::new)
                .toList();
    }

    public ArmazenamentoResponseDTO atualizar(ArmazenamentoRequestDTO armazenamentoDTO) {
        Armazenamento armazenamento = new Armazenamento();
        BeanUtils.copyProperties(armazenamentoDTO, armazenamento);
        Optional<Armazenamento> armazenamentoOptional = armazenamentoRepository.findById(armazenamento.getIdArmazenamento());
        if (armazenamentoOptional.isPresent()) {
            armazenamento.setPontoColeta(pontoColetaRepository.getReferenceById(armazenamentoDTO.pontoColeta()));
            armazenamento.setTipoResiduo(tipoResiduoRepository.getReferenceById(armazenamentoDTO.tipoResiduo()));
            Armazenamento armazenamentoSalvo = armazenamentoRepository.save(armazenamento);
            return new ArmazenamentoResponseDTO(armazenamentoSalvo);
        } else {
            throw new RuntimeException("Armazenamento não encontrado.");
        }
    }

    public void excluir(Long id) {
        Optional<Armazenamento> armazenamentoOptional = armazenamentoRepository.findById(id);
        if (armazenamentoOptional.isPresent()){
            armazenamentoRepository.deleteById(id);
        } else {
            throw new RuntimeException("armazenamento não encontrado");
        }
    }
}
