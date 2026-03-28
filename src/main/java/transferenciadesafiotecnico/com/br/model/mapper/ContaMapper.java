package transferenciadesafiotecnico.com.br.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import transferenciadesafiotecnico.com.br.model.Conta;
import transferenciadesafiotecnico.com.br.model.dto.ContaRecord;

@Mapper(componentModel = "spring")
public interface ContaMapper {

    ContaMapper INSTANCE = Mappers.getMapper( ContaMapper.class );

    @Mapping(target = "usuario.nomeCompleto", source = "nomeCompleto")
    @Mapping(target = "usuario.cpfCnpj", source = "cpfCnpj")
    @Mapping(target = "usuario.tipoPessoa", source = "tipoPessoa")
    @Mapping(target = "usuario.email", source = "email")
    @Mapping(target = "usuario.senha", ignore = true)
    @Mapping(target = "idConta", ignore = true)
    Conta contaRecordToConta(ContaRecord conta);
}
