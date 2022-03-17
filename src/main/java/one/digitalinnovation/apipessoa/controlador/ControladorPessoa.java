package one.digitalinnovation.apipessoa.controlador;

import lombok.AllArgsConstructor;
import one.digitalinnovation.apipessoa.dto.pedido.PessoaDTO;
import one.digitalinnovation.apipessoa.dto.resposta.MessagemResposta;
import one.digitalinnovation.apipessoa.excecoes.PessoaNaoEncontradaException;
import one.digitalinnovation.apipessoa.servico.ServicoPessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/pessoas")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ControladorPessoa {

    private final ServicoPessoa servicoPessoa;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessagemResposta criarPessoa(@RequestBody @Valid PessoaDTO pessoaDTO) {
        return servicoPessoa.criarPessoa(pessoaDTO);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PessoaDTO buscar(@PathVariable Long id) throws PessoaNaoEncontradaException {
        return servicoPessoa.buscar(id);
    }


    @GetMapping
    public List<PessoaDTO> listAll(){
       return servicoPessoa.listarPessoas();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MessagemResposta atualizarPessoa(@PathVariable Long id, @RequestBody PessoaDTO pessoaDTO) throws PessoaNaoEncontradaException{
        return servicoPessoa.atualizarPessoa(id, pessoaDTO);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarPessoa(@PathVariable Long id) throws PessoaNaoEncontradaException{
        servicoPessoa.deletarPessoa(id);
    }


}
