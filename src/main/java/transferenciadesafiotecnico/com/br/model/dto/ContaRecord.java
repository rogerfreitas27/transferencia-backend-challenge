package transferenciadesafiotecnico.com.br.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import transferenciadesafiotecnico.com.br.model.enums.TipoPessoaEnum;

import java.math.BigDecimal;

public record ContaRecord(
        @NotBlank(message = "Nome é obrigatório")
        @Size(max = 255, message = "O campo nome deve  ter no máximo 255 caracteres")
        String nomeCompleto,

        @Pattern(regexp = "(^\\d{11}$)|(^\\d{14}$)", message = "CPF ou CNPJ inválido")
        String cpfCnpj,

        TipoPessoaEnum tipoPessoa,

        @Email
        @NotBlank(message="Email é obrigatório")
        @Size(max = 150, message = "O campo email deve  ter no máximo 150 caracteres")
        String email ,

        @Digits(integer = 10, fraction = 2,
                message = "O campo valor deve possuir até 10 dígitos inteiros e 2 decimais")
        @DecimalMin(value = "0.01",
                message = "O valor não deve ser negativo e nem 0.00")
        BigDecimal saldo,
        @JsonProperty(access = JsonProperty.Access.READ_ONLY) Long idConta

) {
}
