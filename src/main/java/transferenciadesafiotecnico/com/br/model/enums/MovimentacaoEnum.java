package transferenciadesafiotecnico.com.br.model.enums;

import lombok.Getter;

@Getter
public enum MovimentacaoEnum {
    CREDITO("C"),
    DEBITO("D");
    private String sigla;

    MovimentacaoEnum(String sigla){
        this.sigla = sigla;
    }

}
