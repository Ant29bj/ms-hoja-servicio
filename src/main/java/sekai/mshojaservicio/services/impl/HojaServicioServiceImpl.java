package sekai.mshojaservicio.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

        return hojaServicioRepository.save(hojaServicio);
    }

    @Override
    public String generarNoOrden(String noEquipo) {
        LocalDate fechaActual = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        return fechaActual.format(formatter) + noEquipo;
    }
}
