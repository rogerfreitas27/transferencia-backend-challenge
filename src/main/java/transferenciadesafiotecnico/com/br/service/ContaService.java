package transferenciadesafiotecnico.com.br.service;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import transferenciadesafiotecnico.com.br.model.Conta;
import transferenciadesafiotecnico.com.br.model.Usuario;
import transferenciadesafiotecnico.com.br.model.dto.ContaRecord;
import transferenciadesafiotecnico.com.br.model.mapper.ContaMapper;
import transferenciadesafiotecnico.com.br.repository.ContaRepository;


@Service
@RequiredArgsConstructor
public class ContaService {

    private final ContaRepository repository;
    private final ContaMapper MAPPER = ContaMapper.INSTANCE;
    private final ValidacaoConta validacaoConta;
    private final MovimentacaoService movimentacaoService;
    private  final UsuarioService usuarioService;

    @Transactional
    public ContaRecord criarConta (ContaRecord contaRecord){
        Conta conta = MAPPER.contaRecordToConta(contaRecord);
        validacaoConta.validaCriacaoConta(conta);
        Usuario usuario = conta.getUsuario();
        usuario.setConta(conta);
        usuario = usuarioService.criarUsuario(conta.getUsuario());
        movimentacaoService.criarMovimentacaoAberturaConta(usuario.getConta());

        return contaRecord;
    }


}
