package br.com.reciclahub.repository;

import br.com.reciclahub.model.Coleta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ColetaRepository extends JpaRepository<Coleta, Long> {

    List<Coleta> findByEmpresaIdEmpresa(Long idEmpresa);

}