package sekai.mshojaservicio.repository;

import lombok.extern.java.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import sekai.mshojaservicio.dto.HojaServicio;

public interface HojaServicioRepository extends JpaRepository<HojaServicio, Log> {
    public abstract HojaServicio findByNoOrden(String noOrden);
}
