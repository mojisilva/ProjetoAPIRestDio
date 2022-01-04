package one.digitalinnovation.personapi.servico;

import one.digitalinnovation.personapi.dto.MessagemResposta;
import one.digitalinnovation.personapi.entidades.Pessoa;
import one.digitalinnovation.personapi.repositorio.RepositorioPessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicoPessoa {

    private RepositorioPessoa repositorioPessoa;

    @Autowired
    public ServicoPessoa(RepositorioPessoa repositorioPessoa) {
        this.repositorioPessoa = repositorioPessoa;
    }

    public MessagemResposta criaPessoa(Pessoa pessoa) {
        Pessoa pessoasalva = repositorioPessoa.save(pessoa);
        return MessagemResposta
                .builder()
                .mensagem("Pessoa criada com ID:" + pessoasalva.getId())
                .build();
    }
}
