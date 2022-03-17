package one.digitalinnovation.apipessoa.dto.mapeador;

import one.digitalinnovation.apipessoa.dto.pedido.PessoaDTO;
import one.digitalinnovation.apipessoa.entidades.Pessoa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MapeadorPessoa {

    @Mapping(target = "aniversario", source = "aniversario", dateFormat = "dd-MM-yyyy")
    Pessoa toModel(PessoaDTO pessoaDTO);

    PessoaDTO toDTO(Pessoa pessoa);

}
