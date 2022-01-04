package one.digitalinnovation.personapi.repositorio;

import one.digitalinnovation.personapi.entidades.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioPessoa extends JpaRepository<Pessoa,Long> {
}
