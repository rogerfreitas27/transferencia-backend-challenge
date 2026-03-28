package transferenciadesafiotecnico.com.br.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import transferenciadesafiotecnico.com.br.model.enums.TipoPessoaEnum;

import java.math.BigDecimal;

public record ContaRecord(
        String nomeCompleto,
        String cpfCnpj,
        TipoPessoaEnum tipoPessoa,
        String email ,
        BigDecimal saldo,
        @JsonProperty(access = JsonProperty.Access.READ_ONLY) Long idConta

) {
}
