package br.com.reciclahub.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "tbl_coleta")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Coleta {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_COLETA")
    @SequenceGenerator(
            name = "SEQ_COLETA",
            sequenceName = "SEQ_COLETA",
            allocationSize = 1
    )
    @Column(name = "id_coleta")
    private Long idColeta;

    @ManyToOne
    @JoinColumn(name = "id_armazenamento")
    private Armazenamento armazenamento;

    @ManyToOne
    @JoinColumn(name = "id_empresa")
    private Empresa empresa;

    @Column(name = "data_coleta")
    private LocalDate dataColeta;

    @Column(name = "quantidade_coletada")
    private Double quantidadeColetada;
}