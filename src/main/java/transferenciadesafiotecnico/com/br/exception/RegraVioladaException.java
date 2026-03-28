package transferenciadesafiotecnico.com.br.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

import java.util.Objects;

public class RegraVioladaException extends RuntimeException{

    private String mensagem;
    public RegraVioladaException(){

    }

    public RegraVioladaException(String mensagem){
        this.mensagem = mensagem;
    }

    public ProblemDetail toProblemDetail() {
        var pb = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        pb.setTitle("Regra violada Exception");
        if(Objects.nonNull(mensagem) && !mensagem.isBlank())
          pb.setDetail(mensagem);
        return pb;
    }
}
