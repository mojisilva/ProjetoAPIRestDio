package one.digitalinnovation.personapi.dto.pedido;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import one.digitalinnovation.personapi.entidades.Telefone;
import org.hibernate.validator.constraints.br.CPF;
<<<<<<< HEAD

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
=======
>>>>>>> 6d4cf7006e235248aea18443f8b9c73931c789c5
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PessoaDTO {

    private Long id;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String nome;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String sobrenome;

    @NotEmpty
    @CPF
    private String cpf;

    private String aniversario;

<<<<<<< HEAD
    @Valid
    @NotEmpty
=======
    @NotEmpty
    @Valid
>>>>>>> 6d4cf7006e235248aea18443f8b9c73931c789c5
    private List<Telefone> telefones;

}
