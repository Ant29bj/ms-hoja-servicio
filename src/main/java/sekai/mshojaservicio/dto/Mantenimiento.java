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
public class Mantenimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean mantenimientoGabinete;

    private Boolean organizacionEstadoCableado;

    private Boolean mantenimientoPc;

    private Boolean mantenimientoMonitor;

    private Boolean mantenimientoEscaner;

    private Boolean mantenimientoImpresora;

    private Boolean mantenimientoTarjetaInterfaz;

    private Boolean mantenimientoToneleros;

    private Boolean mantenimientoDispensadorBilletes;

    private Boolean mantenimientoAceptadorBilletes;

    private Boolean mantenimientoAceptadorMonedas;

    // pendiente revision Ups

    private String verificacionUltimaVersionLiberada;

    private Boolean actualizacionAntivirusCorporativo;

    private Boolean verificaFechaHora;

    @OneToMany(mappedBy = "noOrden", fetch = FetchType.LAZY)
    private List<HojaServicio> hojaServicios = new ArrayList<>();
}
