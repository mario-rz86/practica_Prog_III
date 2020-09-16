package ar.edu.undec.mascotas.usecaseunittest;

import ar.edu.undec.mascotas.casosUso.CrearMascotaCasoUso;
import ar.edu.undec.mascotas.domain.Mascota;
import ar.edu.undec.mascotas.repositorio.ICrearMascotaRepositorio;
import mockito.MockitoExtension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import java.time.LocalDate;

import static org.mockito.Mockito.when;

@ExtendWith({MockitoExtension.class})
public class CrearMascotaCasoUsoTest {

    @Mock
    ICrearMascotaRepositorio crearMascotaRepositorio;

    @Test
    void crearMascota_mascotaNoExiste_crearMascota(){
        //Arrange
        Mascota laMascota =  Mascota.instancia("toby","callejero", LocalDate.of(2005,1,1));
        CrearMascotaCasoUso crearMascotaCasoUso = new CrearMascotaCasoUso(crearMascotaRepositorio);

        //Simulo BD
        when(crearMascotaRepositorio.existe(laMascota.getNombre())).thenReturn(false);
        when(crearMascotaRepositorio.guardarMascota(laMascota)).thenReturn(true);

        //Act
        boolean resultado = crearMascotaCasoUso.crearMascota(laMascota);

        //Assert
        Assertions.assertTrue(resultado);
    }
}
