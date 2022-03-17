package one.digitalinnovation.apipessoa.dto.pedido;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import one.digitalinnovation.apipessoa.entidades.Telefone;
import org.hibernate.validator.constraints.br.CPF;
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


    @Valid
    @NotEmpty
    private List<Telefone> telefones;

}
