package br.com.reciclahub.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table (name = "tbl_alerta")
@Getter
@Setter
@NoArgsConstructor // Construtor vazio
@AllArgsConstructor // Construtor com todos os atributps
@EqualsAndHashCode // Métodos Equals e HashCode
public class Alerta {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ALERTA")
    @SequenceGenerator(name="SEQ_ALERTA", sequenceName = "SEQ_ALERTA", allocationSize = 1)
    @Column(name = "id_alerta")
    private Long idAlerta;

    @ManyToOne
    @JoinColumn(name = "id_armazenamento")
    private Armazenamento armazenamento;

    @ManyToOne
    @JoinColumn(name = "id_empresa")
    private Empresa empresa;

    private String descricao;

    @Column (name = "data_alerta")
    private LocalDate dataAlerta;
    private String status;
}
