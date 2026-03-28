package transferenciadesafiotecnico.com.br.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import transferenciadesafiotecnico.com.br.model.Usuario;

import java.util.Optional;

public interface UsuarioRepsitory extends JpaRepository<Usuario,Long> {

    @Query("From Usuario u where LOWER(u.email) = LOWER(:email) or u.cpfCnpj=:cpf")
    Optional<Usuario> buscaUsuarioPorEmailOrCpfCnpj(String email, String cpf);
}
