package sekai.mshojaservicio.controller;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sekai.mshojaservicio.dto.HojaServicio;
import sekai.mshojaservicio.services.HojaServicioService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hoja_servicio")
@CrossOrigin
public class HojaServicioController {

    @Autowired
    private HojaServicioService hojaServicioService;

    @GetMapping
    private ResponseEntity<HojaServicio> buscarHojaServicio(@RequestParam(name = "noOrden") String noOrden){
        Optional<HojaServicio> hojaServicioOptional = hojaServicioService.obtenerHoja(noOrden);
        return hojaServicioOptional.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/all")
    private ResponseEntity<List<HojaServicio>> traerTodasLasHojas(){
        List<HojaServicio> hojaServicios = hojaServicioService.obtenerHojas();

        if(!hojaServicios.isEmpty()){
            return ResponseEntity.ok(hojaServicios);
        }else {
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping
    private ResponseEntity<Object> agregarHoja(@RequestBody HojaServicio hojaServicio){
        try {
            HojaServicio nuevaHoja = hojaServicioService.agregarServicio(hojaServicio);
            return new ResponseEntity<>(nuevaHoja, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
