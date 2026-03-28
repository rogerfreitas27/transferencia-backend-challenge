package transferenciadesafiotecnico.com.br.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import transferenciadesafiotecnico.com.br.model.enums.MovimentacaoEnum;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@Entity
@Table(name="tb_movimentacao")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Movimentacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_movimentacao")
    private Long idMovimentacao;

    @Column(name="valor")
    private BigDecimal valor;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "conta_origem_id")
    private Conta origem;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "conta_destino_id")
    private Conta destino;

    @Column(name = "data_hora_movimentacao")
    private LocalDateTime dataHoraMovimentacao;

    @Enumerated(EnumType.STRING)
    @Column(name="tipo")
    private MovimentacaoEnum tipo;


}
