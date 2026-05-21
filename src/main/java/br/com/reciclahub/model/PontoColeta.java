package br.com.reciclahub.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_ponto_coleta")
@Getter
@Setter
@NoArgsConstructor // Construtor vazio
@AllArgsConstructor // Construtor com todos os atributps
@EqualsAndHashCode // Métodos Equals e HashCode
public class PontoColeta {

@Id
@GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "SEQ_PONTO_COLETA")
@SequenceGenerator (name = "SEQ_PONTO_COLETA", sequenceName = "SEQ_PONTO_COLETA", allocationSize = 1)
@Column(name = "id_ponto")
private Long idPontoColeta;

@Column(name = "nome_local")
private String nomeLocal;

private String endereco;

@Column(name = "capacidade_total")
private Integer capacidadeTotal;

    @ManyToOne
    @JoinColumn(name = "id_empresa")
    private Empresa empresa;

}
