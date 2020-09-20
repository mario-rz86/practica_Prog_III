package ar.edu.undec.mascotas.usecaseunittest;

import ar.edu.undec.mascotas.casosUso.ModificarMascotaCasoUso;
import ar.edu.undec.mascotas.casosUso.excepciones.ModificarMascotaException;
import ar.edu.undec.mascotas.domain.Mascota;
import ar.edu.undec.mascotas.repositorio.IConsultarMascotaPorNombreRepositorio;
import ar.edu.undec.mascotas.repositorio.IModificarMascotaRepositorio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.time.LocalDate;

import static org.mockito.Mockito.when;

public class ModificarMascotaCasoUsoTest {

    @Mock
    IModificarMascotaRepositorio iModificarMascotaRepositorio;

    @Mock
    IConsultarMascotaPorNombreRepositorio iConsultarMascotaPorNombreRepositorio;

    @Test
    void modificarMascota_DatosCorrectos_mascotaModificada() throws ModificarMascotaException {
        Mascota mascotaAModificar = Mascota.instancia("batuque","pitbull", LocalDate.of(2019,6,15));
        Mascota mascotaDatosNuevos = Mascota.instancia("batuque","obejero belga", LocalDate.of(2019,6,15));

        when(iConsultarMascotaPorNombreRepositorio.findByNombre("batuque")).thenReturn(mascotaAModificar);
        when(iModificarMascotaRepositorio.update(mascotaAModificar)).thenReturn(true);

        ModificarMascotaCasoUso modificarMascotaCasoUso = new ModificarMascotaCasoUso(iModificarMascotaRepositorio, iConsultarMascotaPorNombreRepositorio);

        Mascota mascota = modificarMascotaCasoUso.modificarMascota(mascotaDatosNuevos);
        Assertions.assertEquals("obejero belga",mascota.getRaza());

    }

}
