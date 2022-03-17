package one.digitalinnovation.apipessoa.repositorio;

import one.digitalinnovation.apipessoa.entidades.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioPessoa extends JpaRepository<Pessoa, Long> {
}
