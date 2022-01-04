package one.digitalinnovation.personapi.controller;

import one.digitalinnovation.personapi.dto.resposta.MessagemResposta;
import one.digitalinnovation.personapi.entidades.Pessoa;
import one.digitalinnovation.personapi.repositorio.RepositorioPessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/pessoas")
public class PessoaController {

    private RepositorioPessoa repositorioPessoa;

    @Autowired
    public PessoaController(RepositorioPessoa repositorioPessoa) {
        this.repositorioPessoa = repositorioPessoa;
    }

    @PostMapping
    public MessagemResposta criaPessoa(@RequestBody Pessoa pessoa){
        Pessoa pessoasalva = repositorioPessoa.save(pessoa);
        return MessagemResposta
                .builder()
                .mensagem("Pessoa criada com ID:" + pessoasalva.getId())
                .build();
    }
}
