package sekai.mshojaservicio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sekai.mshojaservicio.dto.HojaServicio;

public interface HojaServicioRepository extends JpaRepository<HojaServicio, Long> {
    public abstract HojaServicio findByNoOrden(String noOrden);
}
