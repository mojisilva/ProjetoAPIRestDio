package one.digitalinnovation.personapi.dto.pedido;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import one.digitalinnovation.personapi.enums.TipoTelefone;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
<<<<<<< HEAD
=======

>>>>>>> 6d4cf7006e235248aea18443f8b9c73931c789c5
public class TelefoneDTO {

    private long id;

    @Enumerated(EnumType.STRING)
    private TipoTelefone tipo;

    @NotEmpty
<<<<<<< HEAD
    @Size(min= 10, max = 14)
=======
    @Size(min= 13, max = 14)
>>>>>>> 6d4cf7006e235248aea18443f8b9c73931c789c5
    private String numero;

}
