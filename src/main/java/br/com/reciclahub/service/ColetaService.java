package br.com.reciclahub.service;

import br.com.reciclahub.dto.ColetaRequestDTO;
import br.com.reciclahub.dto.ColetaResponseDTO;
import br.com.reciclahub.dto.EmpresaResponseDTO;
import br.com.reciclahub.dto.PontoColetaResponseDTO;
import br.com.reciclahub.model.Coleta;
import br.com.reciclahub.model.Empresa;
import br.com.reciclahub.repository.ColetaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ColetaService {

    @Autowired
    private ColetaRepository coletaRepository;

    public ColetaResponseDTO salvar(ColetaRequestDTO coletaRequestDTO) {
        Coleta coleta = new Coleta();
        BeanUtils.copyProperties(coletaRequestDTO, coleta); // criando objeto empresa (model)
        // com tudo que recebemos de empresaDTO copiando
        // e passando de empresaDTO para empresa
        Coleta coletaSalva = coletaRepository.save(coleta);
        return new ColetaResponseDTO(coletaSalva); }

    public List<ColetaResponseDTO> listarPorEmpresa (Long id) {
        return coletaRepository.findByEmpresaIdEmpresa(id).stream()
            .map(ColetaResponseDTO::new)
            .toList();}

    public Coleta atualizar(Coleta coleta) {
        Optional<Coleta> coletaOptional = coletaRepository.findById(coleta.getIdColeta());
        if (coletaOptional.isPresent()) {
            return coletaRepository.save(coleta);
        } else {
            throw new RuntimeException("Coleta não encontrada.");
        }
    }


}
