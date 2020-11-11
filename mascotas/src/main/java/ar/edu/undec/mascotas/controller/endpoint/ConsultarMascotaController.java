package ar.edu.undec.mascotas.controller.endpoint;

import ar.edu.undec.mascotas.controller.dtomodel.MascotaDTO;
import ar.edu.undec.mascotas.core.casosUso.input.IConsultarMascotasInput;
import com.fasterxml.jackson.core.PrettyPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/veterinaria")
public class ConsultarMascotaController {

    @Autowired
    IConsultarMascotasInput consultarMascotasInput;

    @GetMapping(value = "/mascotas")
    public ResponseEntity<?> consultarMascotas() {

        ResponseEntity<?> laRespuesta = null;

        Collection<MascotaDTO> mascotaDTOCollection = consultarMascotasInput.consultarMascotas()
                .stream()
                .map(mascota -> new MascotaDTO(mascota.getNombre(), mascota.getRaza(), mascota.getFechaNacimiento()))
                .collect(Collectors.toCollection(ArrayList::new));

        laRespuesta = ResponseEntity.ok(mascotaDTOCollection);

        return laRespuesta;
    }
}
