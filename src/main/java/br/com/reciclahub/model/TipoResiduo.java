package br.com.reciclahub.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_tipo_residuo")
@Getter
@Setter
@NoArgsConstructor // Construtor vazio
@AllArgsConstructor // Construtor com todos os atributps
@EqualsAndHashCode // Métodos Equals e HashCode
public class TipoResiduo {

    @Id
    @Column(name = "id_tipo")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TIPO_RESIDUO")
    @SequenceGenerator (name = "SEQ_TIPO_RESIDUO", sequenceName = "SEQ_TIPO_RESIDUO", allocationSize = 1)
    private Long id;

    private String nome;
    private String descricao;

    @Column(name = "limite_maximo")
    private Integer limiteMaximo;
}
