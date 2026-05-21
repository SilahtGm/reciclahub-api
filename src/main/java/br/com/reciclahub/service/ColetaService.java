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
import br.com.reciclahub.repository.EmpresaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ColetaService {

    @Autowired
    private ColetaRepository coletaRepository;

    @Autowired
    private ArmazenamentoRepository armazenamentoRepository;

    @Autowired
    private EmpresaRepository empresaRepository;

    public ColetaResponseDTO salvar(ColetaRequestDTO coletaRequestDTO) {
        Armazenamento armazenamento = armazenamentoRepository
                .findById(coletaRequestDTO.idArmazenamento())
                .orElseThrow(() -> new RuntimeException("Armazenamento não encontrado"));


        verificarEAtualizarEstoque(armazenamento, coletaRequestDTO.quantidadeColetada());

        Coleta coleta = new Coleta();
        coleta.setArmazenamento(armazenamento);
        coleta.setEmpresa(empresaRepository.getReferenceById(coletaRequestDTO.idEmpresa()));
        coleta.setDataColeta(coletaRequestDTO.dataColeta());
        coleta.setQuantidadeColetada(coletaRequestDTO.quantidadeColetada());

        return new ColetaResponseDTO(coletaRepository.save(coleta));
    }

    public List<ColetaResponseDTO> listarPorEmpresa(Long id) {
        return coletaRepository.findByEmpresaIdEmpresa(id).stream()
                .map(ColetaResponseDTO::new)
                .toList();
    }

    public ColetaResponseDTO atualizar(ColetaRequestDTO coletaDTO) {
        Coleta coleta = coletaRepository.findById(coletaDTO.idColeta())
                .orElseThrow(() -> new RuntimeException("Coleta não encontrada."));

        Armazenamento armazenamento = armazenamentoRepository
                .findById(coletaDTO.idArmazenamento())
                .orElseThrow(() -> new RuntimeException("Armazenamento não encontrado"));

        Empresa empresa = empresaRepository
                .findById(coletaDTO.idEmpresa())
                .orElseThrow(() -> new RuntimeException("Empresa não encontrada"));

        coleta.setArmazenamento(armazenamento);
        coleta.setEmpresa(empresa);
        coleta.setDataColeta(coletaDTO.dataColeta());
        coleta.setQuantidadeColetada(coletaDTO.quantidadeColetada());

        return new ColetaResponseDTO(coletaRepository.save(coleta));
    }

    private void verificarEAtualizarEstoque(Armazenamento armazenamento, Double quantidadeColetada) {
        if (quantidadeColetada > armazenamento.getQuantidadeAtual()) {
            throw new RuntimeException("Quantidade maior que estoque disponível");
        }
        armazenamento.setQuantidadeAtual(armazenamento.getQuantidadeAtual() - quantidadeColetada);
        armazenamentoRepository.save(armazenamento);
    }
}
