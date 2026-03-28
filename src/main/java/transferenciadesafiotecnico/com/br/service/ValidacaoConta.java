package transferenciadesafiotecnico.com.br.service;

import org.springframework.stereotype.Component;
import transferenciadesafiotecnico.com.br.exception.RegraVioladaException;
import transferenciadesafiotecnico.com.br.model.Conta;
import transferenciadesafiotecnico.com.br.model.enums.TipoPessoaEnum;
import java.math.BigDecimal;

@Component
public class ValidacaoConta {

    public void validaCriacaoConta(Conta conta){
        if(TipoPessoaEnum.FISICA.equals(conta.getUsuario().getTipoPessoa())){
            String cpf =  conta.getUsuario().getCpfCnpj().replaceAll("\\D", "");
            if(cpf.length() != 11) throw new RegraVioladaException("Para pessoa física é obrigatório ter cpf");
            conta.getUsuario().setCpfCnpj(cpf);
        }else{
            String cnpj =  conta.getUsuario().getCpfCnpj().replaceAll("\\D", "");
            if(cnpj.length() != 14) throw new RegraVioladaException("Para pessoa jurídica é obrigatório ter cnpj");
            conta.getUsuario().setCpfCnpj(cnpj);
        }
        checaTransferenciaZerada(conta.getSaldo());
    }

    private void checaTransferenciaZerada(BigDecimal valor){
        if(valor.compareTo(BigDecimal.ZERO) == 0) throw new RegraVioladaException("Conta não pode ser movimentada com valor 0,00");
    }
}
