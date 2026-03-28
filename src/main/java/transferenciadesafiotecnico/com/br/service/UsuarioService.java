package transferenciadesafiotecnico.com.br.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import transferenciadesafiotecnico.com.br.exception.RegraVioladaException;
import transferenciadesafiotecnico.com.br.model.Usuario;
import transferenciadesafiotecnico.com.br.repository.UsuarioRepsitory;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepsitory repository;
    private final PasswordEncoder passwordEncoder;


    public Usuario criarUsuario (Usuario usuario){
        Optional<Usuario> usuarioBanco = repository.buscaUsuarioPorEmailOrCpfCnpj(usuario.getEmail(), usuario.getCpfCnpj());
           if(usuarioBanco.isPresent()){
            throw new  RegraVioladaException("Email ou cpf/cnpj já existe");
        }

        usuario.setSenha(criaECriptografaSenha());
        return repository.save(usuario);
    }

    private String criaECriptografaSenha() {
        return passwordEncoder.encode(geradorSenha());
    }

    private String geradorSenha(){
        return UUID.randomUUID().toString();
    }
}
