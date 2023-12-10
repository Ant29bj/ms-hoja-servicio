package sekai.mshojaservicio.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Ups {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean estado;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "voltaje_entrada")
    private Voltajes voltajesEntrada;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "voltaje_salida")
    private Voltajes voltajesSalida;

}
