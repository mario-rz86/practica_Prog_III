package ar.edu.undec.mascotas.persistencetest;

import ar.edu.undec.mascotas.casosUso.excepciones.MascotaIncompletaException;
import ar.edu.undec.mascotas.domain.Mascota;
import ar.edu.undec.mascotas.persistencia.CrearMascotaRepoImpl;
import ar.edu.undec.mascotas.persistencia.crud.ICrearMascotaCRUD;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest

public class CrearMascotaDataTest {

    @Autowired
    CrearMascotaRepoImpl crearMascotaRepo;



    @Test
    public void testCrearMascota() throws MascotaIncompletaException {
        Mascota laMascota =  Mascota.instancia("toby","callejero", LocalDate.of(2005,1,1));

        boolean resultado = crearMascotaRepo.guardarMascota(laMascota);
        Assertions.assertTrue(resultado);
    }
}
