package one.digitalinnovation.personapi.controller;

import one.digitalinnovation.personapi.dto.pedido.PessoaDTO;
import one.digitalinnovation.personapi.dto.resposta.MessagemResposta;
import one.digitalinnovation.personapi.excecoes.PessoaNaoEncontradaException;
import one.digitalinnovation.personapi.servico.ServicoPessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

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
    public MessagemResposta criaPessoa(@RequestBody @Valid PessoaDTO pessoaDTO) {
        return servicoPessoa.criaPessoa(pessoaDTO);
    }

    @GetMapping
    public List<PessoaDTO> listAll(){
       return servicoPessoa.listAll();
    }

    @GetMapping("/{id}")
    public PessoaDTO buscar(@PathVariable Long id) throws PessoaNaoEncontradaException {
        return servicoPessoa.buscar(id);
    }
}
