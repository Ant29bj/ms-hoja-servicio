package sekai.mshojaservicio.services.impl;

import org.apache.el.util.ReflectionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;
import sekai.mshojaservicio.dto.HojaServicio;
import sekai.mshojaservicio.repository.HojaServicioRepository;
import sekai.mshojaservicio.services.HojaServicioService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class HojaServicioServiceImpl implements HojaServicioService {

    @Autowired
    private HojaServicioRepository hojaServicioRepository;
    @Override
    public Optional<HojaServicio> obtenerHoja(String noOrden) {
        return Optional.ofNullable(hojaServicioRepository.findByNoOrden(noOrden));
    }

    @Override
    public List<HojaServicio> obtenerHojas() {
        return hojaServicioRepository.findAll();
    }

    @Override
    public HojaServicio agregarServicio(HojaServicio hojaServicio) {
        Optional<HojaServicio> optionalHojaServicio = obtenerHoja(hojaServicio.getNoOrden());
        if(optionalHojaServicio.isPresent()){
            throw new IllegalArgumentException("Hoja ya existe");
        }
        hojaServicio.setNoOrden(generarNoOrden(hojaServicio.getNoEquipo()));
        hojaServicio.setFecha(generarFechaFormateada());

        return hojaServicioRepository.save(hojaServicio);
    }

    public  String generarFechaFormateada(){
        LocalDate fechaAcutal = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return fechaAcutal.format(formatter);
    }

    @Override
    public String generarNoOrden(String noEquipo) {
        LocalDate fechaActual = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        return fechaActual.format(formatter) + noEquipo;
    }

    @Override
    public HojaServicio actualizarHoja(HojaServicio hojaServicio) {
        Optional<HojaServicio> optionalHojaServicio = obtenerHoja(hojaServicio.getNoOrden());

        System.out.println(hojaServicio.getNoOrden());

        if (optionalHojaServicio.isPresent()) {
            HojaServicio hojaExistente = optionalHojaServicio.get();

            // Actualizar todos los campos
            hojaExistente.setEmpresa(hojaServicio.getEmpresa());
            hojaExistente.setZona(hojaServicio.getZona());
            hojaExistente.setAgencia(hojaServicio.getAgencia());
            hojaExistente.setFecha(hojaServicio.getFecha());
            hojaExistente.setHoraInicio(hojaServicio.getHoraInicio());
            hojaExistente.setHoraTermino(hojaServicio.getHoraTermino());
            hojaExistente.setNoEquipo(hojaServicio.getNoEquipo());
            hojaExistente.setNoEquipoSerie(hojaServicio.getNoEquipoSerie());
            hojaExistente.setNoInventario(hojaServicio.getNoInventario());
            hojaExistente.setPreventivoCompleto(hojaServicio.getPreventivoCompleto());
            hojaExistente.setCorrectivo(hojaServicio.getCorrectivo());
            hojaExistente.setVerificarComunicacionMonitoreo(hojaServicio.getVerificarComunicacionMonitoreo());
            hojaExistente.setVerificarComunicacionSicom(hojaServicio.getVerificarComunicacionSicom());
            hojaExistente.setPreubasAceptacionBilletes(hojaServicio.getPreubasAceptacionBilletes());
            hojaExistente.setPreubasAceptacionBilletesDesc(hojaServicio.getPreubasAceptacionBilletesDesc());
            hojaExistente.setPruebasDispensadoMonedas(hojaServicio.getPruebasDispensadoMonedas());
            hojaExistente.setPruebasDispensadoMonedasDesc(hojaServicio.getPruebasDispensadoMonedasDesc());
            hojaExistente.setPreubasDispensadoBilletes(hojaServicio.getPreubasDispensadoBilletes());
            hojaExistente.setPruebasDispensadoBilletesDesc(hojaServicio.getPruebasDispensadoBilletesDesc());
            hojaExistente.setPruebasImpresion(hojaServicio.getPruebasImpresion());
            hojaExistente.setDiagnosticoFallas(hojaServicio.getDiagnosticoFallas());
            hojaExistente.setMantenimientoGabinete(hojaServicio.getMantenimientoImpresora());
            hojaExistente.setOrganizacionEstadoCableado(hojaServicio.getOrganizacionEstadoCableado());
            hojaExistente.setMantenimientoPc(hojaServicio.getMantenimientoPc());
            hojaExistente.setMantenimientoMonitor(hojaServicio.getMantenimientoMonitor());
            hojaExistente.setMantenimientoEscaner(hojaServicio.getMantenimientoEscaner());
            hojaExistente.setMantenimientoImpresora(hojaServicio.getMantenimientoImpresora());
            hojaExistente.setMantenimientoTarjetaInterfaz(hojaServicio.getMantenimientoTarjetaInterfaz());
            hojaExistente.setMantenimientoToneleros(hojaServicio.getMantenimientoToneleros());
            hojaExistente.setMantenimientoDispensadorBilletes(hojaServicio.getMantenimientoDispensadorBilletes());
            hojaExistente.setMantenimientoAceptadorBilletes(hojaServicio.getMantenimientoAceptadorBilletes());
            hojaExistente.setMantenimientoAceptadorMonedas(hojaServicio.getMantenimientoAceptadorMonedas());
            hojaExistente.setUps(hojaServicio.getUps());
            hojaExistente.setRefaciones(hojaServicio.getRefaciones());
            hojaExistente.setObservaciones(hojaServicio.getObservaciones());
            hojaExistente.setVerificacionUltimaVersionLiberada(hojaServicio.getVerificacionUltimaVersionLiberada());
            hojaExistente.setActualizacionAntivirusCorporativo(hojaServicio.getActualizacionAntivirusCorporativo());
            hojaExistente.setVerificaFechaHora(hojaServicio.getVerificaFechaHora());
            hojaExistente.setAceptaMantenimiento(hojaServicio.getAceptaMantenimiento());
            hojaExistente.setDetalleServicio(hojaServicio.getDetalleServicio());
            hojaExistente.setCalidadServicio(hojaServicio.getCalidadServicio());

            // Guardar la hoja actualizada
            return hojaServicioRepository.save(hojaExistente);
        } else {
            throw new IllegalArgumentException("Hoja no encontrada para actualizar");
        }
    }


}
