package one.digitalinnovation.personapi.controller;

import one.digitalinnovation.personapi.dto.MessagemResposta;
import one.digitalinnovation.personapi.entidades.Pessoa;
import one.digitalinnovation.personapi.repositorio.RepositorioPessoa;
import one.digitalinnovation.personapi.servico.ServicoPessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/pessoas")
public class PessoaController {

    private ServicoPessoa servicoPessoa;

    @Autowired
    public PessoaController(ServicoPessoa servicoPessoa) {
        this.servicoPessoa = servicoPessoa;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessagemResposta criaPessoa(@RequestBody Pessoa pessoa){
        return servicoPessoa.criaPessoa(pessoa);
    }
}
