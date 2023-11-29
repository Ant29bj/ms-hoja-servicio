package sekai.mshojaservicio.services;

import sekai.mshojaservicio.dto.HojaServicio;

import java.util.List;
import java.util.Optional;

public interface HojaServicioService {
    public Optional<HojaServicio> obtenerHoja(String noOrden);

    public List<HojaServicio>obtenerHojas();

    public HojaServicio agregarServicio(HojaServicio hojaServicio);

    public  String generarNoOrden(String noEquipo);
}
