package transferenciadesafiotecnico.com.br.exception;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.fasterxml.jackson.databind.exc.ValueInstantiationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import transferenciadesafiotecnico.com.br.model.record.ParametroInvalidoRecord;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ErroHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        List<ParametroInvalidoRecord> erros = e.getFieldErrors()
                .stream()
                .map(erro-> new ParametroInvalidoRecord(erro.getField(), erro.getDefaultMessage()))
                .toList();

        ProblemDetail pd = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        pd.setTitle("Campos com erro !");
        pd.setProperty("parametros",erros);
        return pd;


    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ProblemDetail handleValidationExceptions(Exception e) {
        List<ParametroInvalidoRecord> erros = getErroDesserializacao(e);
        ProblemDetail pd = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        pd.setTitle("Campos com erro !");
        pd.setProperty("Parâmetros inválidos",erros);
        return pd;
    }

    @ExceptionHandler(RegraVioladaException.class)
    public ProblemDetail handlePicPayException(RegraVioladaException e) {
        return e.toProblemDetail();
    }

    private List<ParametroInvalidoRecord> getErroDesserializacao(Exception e){
        List<ParametroInvalidoRecord> erros = new ArrayList<>();

        if (e instanceof HttpMessageNotReadableException hmnre) {
            Throwable cause = hmnre.getCause();

            switch (cause) {

                case ValueInstantiationException vie -> {
                    String fieldName = vie.getPath().stream()
                            .map(JsonMappingException.Reference::getFieldName)
                            .reduce((first, second) -> second)
                            .orElse("campo");

                    erros.add(new ParametroInvalidoRecord(fieldName,vie.getCause() != null
                            ? vie.getCause().getMessage()
                            : "Valor inválido "));
                }

                case JsonParseException jpe ->
                    erros.add(new ParametroInvalidoRecord("Erro" ,"Falha ao desserializar json " + jpe.getOriginalMessage()));

                case InvalidFormatException ife -> {
                    String fieldName = ife.getPath().stream()
                            .map(JsonMappingException.Reference::getFieldName)
                            .reduce((first, second) -> second)
                            .orElse("campo");

                    Object valorInformado = ife.getValue();

                    erros.add(new ParametroInvalidoRecord(fieldName,valorInformado.toString()));
                }

                case UnrecognizedPropertyException un -> {
                    String campo = un.getPropertyName();
                    erros.add(new ParametroInvalidoRecord("O campo não existe",campo));
                }

                case JsonMappingException jme ->
                        erros.add(new ParametroInvalidoRecord("",jme.getOriginalMessage()));

                case null, default ->
                        erros.add(new ParametroInvalidoRecord("Erro ao ler o corpo da requisição.",""));
            }
        }
        return erros;
    }

}
