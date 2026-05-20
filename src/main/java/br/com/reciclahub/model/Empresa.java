package br.com.reciclahub.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_empresa")
@Getter
@Setter
@NoArgsConstructor // Construtor vazio
@AllArgsConstructor // Construtor com todos os atributps
@EqualsAndHashCode // Métodos Equals e HashCode
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_EMPRESA")
    @SequenceGenerator(name="SEQ_EMPRESA", sequenceName = "SEQ_EMPRESA", allocationSize = 1)
    @Column(name = "id_empresa")
    private Long idEmpresa;

    private String cnpj;
    private String nome;
    private String email;
    private String senha;
    private String tipo;


}
