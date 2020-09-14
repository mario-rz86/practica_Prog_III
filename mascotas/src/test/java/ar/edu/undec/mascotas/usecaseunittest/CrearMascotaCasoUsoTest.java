package ar.edu.undec.mascotas.usecaseunittest;

import ar.edu.undec.mascotas.casosUso.CrearMascotaCasoUso;
import ar.edu.undec.mascotas.domain.Mascota;
import ar.edu.undec.mascotas.repositorio.ICrearMascotaRepositorio;
import mockito.MockitoExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.time.LocalDate;

@ExtendWith({MockitoExtension.class})
public class CrearMascotaCasoUsoTest {

    ICrearMascotaRepositorio crearMascotaRepositorio;

    @Test
    void crearMascota_mascotaNoExiste_crearMascota(){
        //Arrange
        Mascota laMascota =  Mascota.instancia("toby","callejero", LocalDate.of(2005,1,1));
        CrearMascotaCasoUso crearMascotaCasoUso = new CrearMascotaCasoUso(crearMascotaRepositorio);

        //Act
        boolean resultado = CrearMascotaCasoUso.crearMascota(laMascota);

        //Assert
    }
}
