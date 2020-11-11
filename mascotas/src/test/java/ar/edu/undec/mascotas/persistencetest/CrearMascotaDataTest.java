package ar.edu.undec.mascotas.persistencetest;

import ar.edu.undec.mascotas.core.excepciones.MascotaIncompletaException;
import ar.edu.undec.mascotas.core.domain.Mascota;
import ar.edu.undec.mascotas.persistencia.CrearMascotaRepoImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest

public class CrearMascotaDataTest {

    @Autowired
    CrearMascotaRepoImpl crearMascotaRepo;



    @Test
    public void testCrearMascota() throws MascotaIncompletaException {
        Mascota laMascota =  Mascota.instancia("everest","siberiano", LocalDate.of(2017,7,16));

        boolean resultado = crearMascotaRepo.guardarMascota(laMascota);
        Assertions.assertTrue(resultado);
    }
}
