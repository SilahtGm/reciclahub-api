package br.com.reciclahub.service;

import br.com.reciclahub.dto.PontoColetaRequestDTO;
import br.com.reciclahub.dto.PontoColetaResponseDTO;
import br.com.reciclahub.dto.TipoResiduoResponseDTO;
import br.com.reciclahub.model.Coleta;
import br.com.reciclahub.model.PontoColeta;
import br.com.reciclahub.repository.EmpresaRepository;
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

    @Autowired
    private EmpresaRepository empresaRepository;

    public PontoColetaResponseDTO salvar(PontoColetaRequestDTO pontoColetaRequestDTO) {
        PontoColeta ponto = new PontoColeta();
        BeanUtils.copyProperties(pontoColetaRequestDTO, ponto);
        ponto.setEmpresa(empresaRepository.getReferenceById(pontoColetaRequestDTO.idEmpresa()));
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

    public void excluir(Long id) {
        Optional<PontoColeta> pontoColetaOptional = pontoColetaRepository.findById(id);
        if (pontoColetaOptional.isPresent()){
            pontoColetaRepository.deleteById(id);
        } else {
            throw new RuntimeException("Ponto não encontrado");
        }
    }

    public PontoColetaResponseDTO atualizar(PontoColetaRequestDTO pontoColetaDTO) {
        PontoColeta pontoColeta = new PontoColeta();
        BeanUtils.copyProperties(pontoColetaDTO, pontoColeta);
        Optional<PontoColeta> pontoColetaOptional = pontoColetaRepository.findById(pontoColeta.getIdPontoColeta());
        if (pontoColetaOptional.isPresent()) {
            pontoColeta.setEmpresa(empresaRepository.getReferenceById(pontoColetaDTO.idEmpresa()));
            PontoColeta pontoSalvo = pontoColetaRepository.save(pontoColeta);
            return new PontoColetaResponseDTO(pontoSalvo);
        } else {
            throw new RuntimeException("Ponto não encontrado.");
        }
    }
}
