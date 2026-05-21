package br.com.reciclahub.service;

import br.com.reciclahub.dto.ColetaRequestDTO;
import br.com.reciclahub.dto.ColetaResponseDTO;
import br.com.reciclahub.dto.EmpresaResponseDTO;
import br.com.reciclahub.dto.PontoColetaResponseDTO;
import br.com.reciclahub.model.Armazenamento;
import br.com.reciclahub.model.Coleta;
import br.com.reciclahub.model.Empresa;
import br.com.reciclahub.repository.ArmazenamentoRepository;
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

    @Autowired ArmazenamentoRepository armazenamentoRepository;

    public ColetaResponseDTO salvar(ColetaRequestDTO coletaRequestDTO) {
        verificarEAtualizarEstoque(coletaRequestDTO);
        Coleta coleta = new Coleta();
        BeanUtils.copyProperties(coletaRequestDTO, coleta);
        Coleta coletaSalva = coletaRepository.save(coleta);
        return new ColetaResponseDTO(coletaSalva); }

    public List<ColetaResponseDTO> listarPorEmpresa (Long id) {
        return coletaRepository.findByEmpresaIdEmpresa(id).stream()
            .map(ColetaResponseDTO::new)
            .toList();}

    public ColetaResponseDTO atualizar(ColetaRequestDTO coletaDTO) {
        Coleta coleta = new Coleta();
        BeanUtils.copyProperties(coletaDTO, coleta);
        Optional<Coleta> coletaOptional = coletaRepository.findById(coleta.getIdColeta());
        if (coletaOptional.isPresent()) {
            Coleta coletaSalva = coletaRepository.save(coleta);
            return new ColetaResponseDTO(coletaSalva);
        } else {
            throw new RuntimeException("Coleta não encontrada.");
        }
    }

    private void verificarEAtualizarEstoque(ColetaRequestDTO coletaRequestDTO) {

        Armazenamento armazenamento = armazenamentoRepository
                .findById(coletaRequestDTO.idArmazenamento())
                .orElseThrow(() ->
                        new RuntimeException("Armazenamento não encontrado"));

        // Verifica estoque
        if (coletaRequestDTO.quantidadeColetada() >
                armazenamento.getQuantidadeAtual()) {

            throw new RuntimeException(
                    "Quantidade maior que estoque disponível");
        }

        // Atualiza estoque
        armazenamento.setQuantidadeAtual(
                armazenamento.getQuantidadeAtual()
                        - coletaRequestDTO.quantidadeColetada()
        );

        armazenamentoRepository.save(armazenamento);
    }


}
