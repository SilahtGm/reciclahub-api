package br.com.reciclahub.service;

import br.com.reciclahub.dto.TipoResiduoRequestDTO;
import br.com.reciclahub.dto.TipoResiduoResponseDTO;
import br.com.reciclahub.model.TipoResiduo;
import br.com.reciclahub.repository.TipoResiduoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoResiduoService {

    @Autowired
    TipoResiduoRepository tipoResiduoRepository;

    public TipoResiduoResponseDTO salvar(TipoResiduoRequestDTO tipoResiduoRequestDTO) {
        TipoResiduo tipoResiduo = new TipoResiduo();
        BeanUtils.copyProperties(tipoResiduoRequestDTO, tipoResiduo);
        TipoResiduo tipoResiduoSalvo = tipoResiduoRepository.save(tipoResiduo);
        return new TipoResiduoResponseDTO(tipoResiduoSalvo);
    }

    public List<TipoResiduoResponseDTO> listarTodos () { return tipoResiduoRepository
            .findAll()
            .stream()
            .map(TipoResiduoResponseDTO::new)
            .toList();}

    public TipoResiduoResponseDTO EncontrarPorId (Long id) {
        Optional<TipoResiduo> tipoResiduoOptional = tipoResiduoRepository.findById(id);
        if (tipoResiduoOptional.isPresent()) {
            return new TipoResiduoResponseDTO(tipoResiduoOptional.get());
        } else {
            throw new RuntimeException("Tipo não encontrado");
        }
    }

    public void excluir(Long id) {
        Optional<TipoResiduo> tipoResiduoOptional = tipoResiduoRepository.findById(id);
        if (tipoResiduoOptional.isPresent()) {
            tipoResiduoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Tipo de resíduo não encontrado");
        }
    }

}
