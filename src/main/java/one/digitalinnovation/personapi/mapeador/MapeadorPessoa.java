package one.digitalinnovation.personapi.mapeador;

import one.digitalinnovation.personapi.dto.pedido.PessoaDTO;
import one.digitalinnovation.personapi.entidades.Pessoa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MapeadorPessoa {

    MapeadorPessoa INSTANCE = Mappers.getMapper(MapeadorPessoa.class);

<<<<<<< HEAD
    @Mapping(target = "aniversario", source = "aniversario", dateFormat = "dd-MM-yyyy")
=======
    @Mapping(target = "aniversario", source = "aniversario", dateFormat = "dd-MM-YYYY")
>>>>>>> 6d4cf7006e235248aea18443f8b9c73931c789c5
    Pessoa toModel(PessoaDTO pessoaDTO);

    PessoaDTO toDTO(Pessoa pessoa);

}
