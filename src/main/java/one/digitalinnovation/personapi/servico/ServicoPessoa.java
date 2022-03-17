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
import org.springframework.web.bind.annotation.RequestBody;

import java.nio.file.ProviderNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ServicoPessoa {

    private final RepositorioPessoa repositorioPessoa;
    private final MapeadorPessoa mapeadorPessoa;


    public MessagemResposta criarPessoa(PessoaDTO pessoaDTO) {
        Pessoa pessoa = mapeadorPessoa.toModel(pessoaDTO);
        Pessoa pessoaCriada = repositorioPessoa.save(pessoa);
        MessagemResposta messagemResposta = criarMensagemResposta("Pessoa criada com ID: ", pessoaCriada.getId());

        return messagemResposta;
    }

    public PessoaDTO buscar(Long id) throws PessoaNaoEncontradaException {
        Pessoa pessoa = repositorioPessoa.findById(id)
                .orElseThrow(() -> new PessoaNaoEncontradaException(id));
        return mapeadorPessoa.toDTO(pessoa);

    }

    public List<PessoaDTO> listarPessoas() {
        List<Pessoa> todasPessoas = repositorioPessoa.findAll();
        return todasPessoas.stream()
                .map(mapeadorPessoa::toDTO)
                .collect(Collectors.toList());
    }

    public MessagemResposta atualizarPessoa(Long id, PessoaDTO pessoaDTO) throws PessoaNaoEncontradaException{
        repositorioPessoa.findById(id)
            .orElseThrow(() -> new PessoaNaoEncontradaException(id));
        Pessoa pessoaAtualizada = mapeadorPessoa.toModel(pessoaDTO);
        Pessoa pessoaSalva = repositorioPessoa.save(pessoaAtualizada);
        MessagemResposta mensagemResposta =criarMensagemResposta("Pessoa atualizada com sucesso ID ", pessoaSalva.getId());
        return mensagemResposta;
    }

    public void deletarPessoa(Long id) throws PessoaNaoEncontradaException{
        repositorioPessoa.findById(id)
                .orElseThrow(() -> new PessoaNaoEncontradaException(id));
        repositorioPessoa.deleteById(id);
    }


    private MessagemResposta criarMensagemResposta(String s, Long id) {
        return MessagemResposta
                .builder()
                .mensagem(s + id)
                .build();
    }

}
