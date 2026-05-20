package br.com.reciclahub.repository;

import br.com.reciclahub.model.TipoResiduo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoResiduoRepository extends JpaRepository<TipoResiduo, Long> {
}