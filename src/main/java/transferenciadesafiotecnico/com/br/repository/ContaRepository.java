package transferenciadesafiotecnico.com.br.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import transferenciadesafiotecnico.com.br.model.Conta;

public interface ContaRepository extends JpaRepository<Conta,Long> {
}
