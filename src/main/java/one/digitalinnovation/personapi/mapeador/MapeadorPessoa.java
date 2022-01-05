package one.digitalinnovation.personapi.mapeador;

import one.digitalinnovation.personapi.dto.pedido.PessoaDTO;
import one.digitalinnovation.personapi.entidades.Pessoa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MapeadorPessoa {

    MapeadorPessoa INSTANCE = Mappers.getMapper(MapeadorPessoa.class);

    @Mapping(target = "aniversario", source = "aniversario", dateFormat = "dd-MM-yyyy")
    Pessoa toModel(PessoaDTO pessoaDTO);

    PessoaDTO toDTO(Pessoa pessoa);

}
