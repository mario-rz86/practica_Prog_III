package ar.edu.undec.mascotas.usecaseunittest;

import ar.edu.undec.mascotas.core.casosUso.CrearMascotaCasoUso;
import ar.edu.undec.mascotas.core.excepciones.MascotaExisteException;
import ar.edu.undec.mascotas.core.excepciones.MascotaIncompletaException;
import ar.edu.undec.mascotas.core.domain.Mascota;
import ar.edu.undec.mascotas.core.repositorio.ICrearMascotaRepositorio;
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
    void crearMascota_mascotaNoExiste_creaMascota() throws MascotaIncompletaException, MascotaExisteException {
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

    @Test
    void crearMascota_mascotaExiste_noCreaMascota() throws MascotaIncompletaException {
        //Arrange
        Mascota laMascota =  Mascota.instancia("toby","callejero", LocalDate.of(2005,1,1));
        CrearMascotaCasoUso crearMascotaCasoUso = new CrearMascotaCasoUso(crearMascotaRepositorio);

        //Simulo BD
        when(crearMascotaRepositorio.existe("toby")).thenReturn(true);

        //Act & Assert
        Assertions.assertThrows(MascotaExisteException.class,()->crearMascotaCasoUso.crearMascota(laMascota));



    }
}
