package br.com.reciclahub.repository;

import br.com.reciclahub.model.Alerta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlertaRepository extends JpaRepository<Alerta, Long> {

    List<Alerta> findByEmpresaIdEmpresa(Long idEmpresa);
}