package br.com.reciclahub.repository;
import br.com.reciclahub.model.Armazenamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArmazenamentoRepository extends JpaRepository <Armazenamento, Long> {

    List<Armazenamento> findByPontoColetaIdPontoColeta(Long idPontoColeta);

}
