package transferenciadesafiotecnico.com.br.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import transferenciadesafiotecnico.com.br.model.dto.ContaRecord;
import transferenciadesafiotecnico.com.br.repository.ContaRepository;

@Service
@RequiredArgsConstructor
public class ContaService {

    private final ContaRepository repository;

    public ContaRecord criarConta (ContaRecord conta){

        return null;
    }
}
