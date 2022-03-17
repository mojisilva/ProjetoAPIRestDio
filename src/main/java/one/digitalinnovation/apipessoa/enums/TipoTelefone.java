package one.digitalinnovation.apipessoa.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoTelefone {

    CASA("Casa"),
    CELULAR("Celular"),
    TRABALHO("Trabalho");

    private final String descricao;

}