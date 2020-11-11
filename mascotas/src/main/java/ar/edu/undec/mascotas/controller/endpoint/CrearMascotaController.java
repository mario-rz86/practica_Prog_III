package ar.edu.undec.mascotas.controller.endpoint;

import ar.edu.undec.mascotas.controller.dtomodel.MascotaDTO;
import ar.edu.undec.mascotas.core.casosUso.input.ICrearMascotaInput;
import ar.edu.undec.mascotas.core.domain.Mascota;
import ar.edu.undec.mascotas.core.excepciones.MascotaExisteException;
import ar.edu.undec.mascotas.core.excepciones.MascotaIncompletaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class CrearMascotaController {

    @Autowired
    ICrearMascotaInput crearMascotaInput;

    @PostMapping(value = "/mascotas")
    public ResponseEntity<?> crearMascota(@RequestBody MascotaDTO laMascota){

        Mascota mascotaCore = null;
        try {
            mascotaCore = Mascota.instancia(laMascota.getNombre(), laMascota.getRaza(), laMascota.getFechaNacimiento());
        } catch (MascotaIncompletaException mascotaIncompleta) {
            mascotaIncompleta.getMessage();
        }

        try {
            boolean resultado=crearMascotaInput.crearMascota(mascotaCore);
            return ResponseEntity.status(HttpStatus.OK).body(resultado);
        } catch (MascotaIncompletaException mascotaIncompleta) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(mascotaIncompleta.getMessage());
        } catch (MascotaExisteException existeLaMascota) {
            return  ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(existeLaMascota.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error Interno del Servidor");
        }


    }
}
