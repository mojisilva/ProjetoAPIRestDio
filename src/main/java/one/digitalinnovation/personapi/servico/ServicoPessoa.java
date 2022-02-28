package one.digitalinnovation.personapi.servico;

import lombok.AllArgsConstructor;
import one.digitalinnovation.personapi.dto.pedido.PessoaDTO;
import one.digitalinnovation.personapi.dto.resposta.MessagemResposta;
import one.digitalinnovation.personapi.entidades.Pessoa;
import one.digitalinnovation.personapi.excecoes.PessoaNaoEncontradaException;
import one.digitalinnovation.personapi.dto.mapeador.MapeadorPessoa;
import one.digitalinnovation.personapi.repositorio.RepositorioPessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ServicoPessoa {

    private final RepositorioPessoa repositorioPessoa;

    private final MapeadorPessoa mapeadorPessoa;


    public PessoaDTO buscar(Long id) throws PessoaNaoEncontradaException {
        Pessoa pessoa = repositorioPessoa.findById(id)
                .orElseThrow(() -> new PessoaNaoEncontradaException(id));
        return mapeadorPessoa.toDTO(pessoa);

    }

    public MessagemResposta criaPessoa(PessoaDTO pessoaDTO) {
        Pessoa pessoa = mapeadorPessoa.toModel(pessoaDTO);
        Pessoa pessoaSalva = repositorioPessoa.save(pessoa);

        return MessagemResposta
                .builder()
                .mensagem("Pessoa criada com ID:" + pessoaSalva.getId())
                .build();
    }

    public List<PessoaDTO> listAll() {
        List<Pessoa> todasPessoas = repositorioPessoa.findAll();
        return todasPessoas.stream()
                .map(mapeadorPessoa::toDTO)
                .collect(Collectors.toList());
    }
}
