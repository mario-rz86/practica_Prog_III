package ar.edu.undec.mascotas.controllertest;

import ar.edu.undec.mascotas.controller.dtomodel.MascotaDTO;
import ar.edu.undec.mascotas.controller.endpoint.CrearMascotaController;
import ar.edu.undec.mascotas.core.casosUso.input.ICrearMascotaInput;
import ar.edu.undec.mascotas.core.domain.Mascota;
import ar.edu.undec.mascotas.core.excepciones.MascotaExisteException;
import ar.edu.undec.mascotas.core.excepciones.MascotaIncompletaException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;

import static org.mockito.Mockito.when;

@SpringBootTest
public class crearMascotaControllerTest {

    @Mock
    ICrearMascotaInput crearMascotaInput;

    @Autowired
    CrearMascotaController crearMascotaController;

    @Test
    void crearMascota_MascotaNoExiste_DevuelveOK200() throws MascotaIncompletaException, MascotaExisteException {

        Mascota laMascota=Mascota.instancia("Chase", "Obejero Aleman", LocalDate.of(2017,6,23));
        MascotaDTO laMascotaDTO=new MascotaDTO("Chase", "Obejero Aleman", LocalDate.of(2017,6,23));

        when(crearMascotaInput.crearMascota(laMascota)).thenReturn(true);

        ResponseEntity<?> laRespuesta = crearMascotaController.crearMascota(laMascotaDTO);

        Assertions.assertEquals(HttpStatus.OK,laRespuesta.getStatusCode());
    }

}
