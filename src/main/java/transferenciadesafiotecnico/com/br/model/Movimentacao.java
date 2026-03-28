package transferenciadesafiotecnico.com.br.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@Entity
@Table(name="tb_movimentacao")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Movimentacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_movimentacao")
    private Long idMovimentacao;

    @Column(name="valor")
    private BigDecimal valor;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_conta_origem")
    private Conta origem;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_conta_destino")
    private Conta destino;

    @Column(name = "data_hora_movimentacao", insertable = false, updatable = false)
    private LocalDateTime dataHoraMovimentacao;

    @Column(name="descricao")
    private String descricao;
}
