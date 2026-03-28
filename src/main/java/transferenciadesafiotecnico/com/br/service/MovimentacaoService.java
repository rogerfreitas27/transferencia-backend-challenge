package transferenciadesafiotecnico.com.br.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import transferenciadesafiotecnico.com.br.model.Conta;
import transferenciadesafiotecnico.com.br.model.Movimentacao;
import transferenciadesafiotecnico.com.br.repository.MovimentacaoRepository;

@Service
@RequiredArgsConstructor
public class MovimentacaoService {

    private final MovimentacaoRepository repository;

    public void criarMovimentacaoAberturaConta(Conta conta){
        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setDestino(conta);
        movimentacao.setOrigem(conta);
        movimentacao.setValor(conta.getSaldo());
        movimentacao.setDescricao("Abertuda de conta");
        repository.save(movimentacao);
    }
}
