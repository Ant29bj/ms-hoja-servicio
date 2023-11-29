package sekai.mshojaservicio.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Pruebas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean verificarComunicacionMonitoreo;

    private Boolean verificarComunicacionSicom;

    private Boolean preubasAceptacionBilletes;

    private String preubasAceptacionBilletesDesc;

    private Boolean pruebasDispensadoMonedas;

    private String pruebasDispensadoMonedasDesc;

    private Boolean preubasDispensadoBilletes;

    private String pruebasDispensadoBilletesDesc;

    private Boolean pruebasImpresion;

    private String diagnosticoFallas;

    @OneToMany(mappedBy = "noOrden", fetch = FetchType.LAZY)
    private List<HojaServicio> hojasServicio = new ArrayList<>();
}
