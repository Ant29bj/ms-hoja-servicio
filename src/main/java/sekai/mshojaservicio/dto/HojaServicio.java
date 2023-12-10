package sekai.mshojaservicio.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import sekai.mshojaservicio.enums.CalidadServicio;
import sekai.mshojaservicio.enums.DetalleServicio;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Slf4j
public class HojaServicio {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;

  @Column(unique = true, nullable = false)
  private String noOrden;

  private String empresa;

  private String zona;

  private String agencia;

  private String fecha;

  private String horaInicio;

  private String horaTermino;

  private String noEquipo;

  private String noEquipoSerie;

  private String noInventario;

  private Boolean preventivoCompleto;

  private Boolean correctivo;

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
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "ups_id")
  private Ups ups;

  private String observaciones;

  private String verificacionUltimaVersionLiberada;

  private Boolean actualizacionAntivirusCorporativo;

  private Boolean verificaFechaHora;

  private Boolean aceptaMantenimiento;

  @Enumerated(EnumType.STRING) private DetalleServicio detalleServicio;

  @Enumerated(EnumType.STRING) private CalidadServicio calidadServicio;
}
