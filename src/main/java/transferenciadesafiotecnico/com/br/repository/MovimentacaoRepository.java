package transferenciadesafiotecnico.com.br.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import transferenciadesafiotecnico.com.br.model.Movimentacao;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao,Long> {
}
