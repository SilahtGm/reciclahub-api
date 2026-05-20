package br.com.reciclahub.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_armazenamento")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Armazenamento {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ARMAZENAMENTO")
    @SequenceGenerator(
            name = "SEQ_ARMAZENAMENTO",
            sequenceName = "SEQ_ARMAZENAMENTO",
            allocationSize = 1
    )
    @Column(name = "id_armazenamento")
    private Long idArmazenamento;

    @ManyToOne
    @JoinColumn(name = "id_ponto")
    private PontoColeta pontoColeta;

    @ManyToOne
    @JoinColumn(name = "id_tipo")
    private TipoResiduo tipoResiduo;

    @Column(name = "quantidade_atual")
    private Double quantidadeAtual;
}