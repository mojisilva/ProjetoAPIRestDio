package one.digitalinnovation.personapi.servico;

import one.digitalinnovation.personapi.dto.pedido.PessoaDTO;
import one.digitalinnovation.personapi.dto.resposta.MessagemResposta;
import one.digitalinnovation.personapi.entidades.Pessoa;
import one.digitalinnovation.personapi.excecoes.PessoaNotFoundException;
import one.digitalinnovation.personapi.mapeador.MapeadorPessoa;
import one.digitalinnovation.personapi.repositorio.RepositorioPessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServicoPessoa {

    private RepositorioPessoa repositorioPessoa;

    private final MapeadorPessoa mapeadorPessoa = MapeadorPessoa.INSTANCE;

    @Autowired
    public ServicoPessoa(RepositorioPessoa repositorioPessoa)  {
        this.repositorioPessoa = repositorioPessoa;
    }

    public PessoaDTO buscar(Long id) throws PessoaNotFoundException {
        Optional<Pessoa> pessoaOptional = repositorioPessoa.findById(id);
        if(pessoaOptional.isEmpty()){
            throw new PessoaNotFoundException(id);
        }
        return mapeadorPessoa.toDTO(pessoaOptional.get());

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
