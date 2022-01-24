package one.digitalinnovation.personapi.excecoes;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PessoaNotFoundException extends Exception {
    public PessoaNotFoundException(Long id) {
        super("Pessoa com id " + id + " não encontrada");
    }
}
