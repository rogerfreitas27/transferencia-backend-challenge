package transferenciadesafiotecnico.com.br.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import transferenciadesafiotecnico.com.br.model.enums.TipoPessoaEnum;

@Entity
@Table(name="tb_usuario")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nome_completo")
    private String nomeCompleto;

    @Column(name="cpf_cnpj")
    private String cpfCnpj;

    @Enumerated(EnumType.STRING)
    @Column(name="tipo_pessoa")
    private TipoPessoaEnum tipoPessoa;

    @Column(name="email")
    private String email;

    @Column(name="senha")
    private String senha;
}
