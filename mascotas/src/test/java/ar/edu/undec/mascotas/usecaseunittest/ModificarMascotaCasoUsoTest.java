package ar.edu.undec.mascotas.usecaseunittest;

import ar.edu.undec.mascotas.casosUso.ModificarMascotaCasoUso;
import ar.edu.undec.mascotas.casosUso.excepciones.ModificarMascotaException;
import ar.edu.undec.mascotas.domain.Mascota;
import ar.edu.undec.mascotas.repositorio.IConsultarMascotaPorNombreRepositorio;
import ar.edu.undec.mascotas.repositorio.IModificarMascotaRepositorio;
import mockito.MockitoExtension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import java.time.LocalDate;

import static org.mockito.Mockito.when;

@ExtendWith({MockitoExtension.class})
public class ModificarMascotaCasoUsoTest {

    @Mock
    IModificarMascotaRepositorio modificarMascotaRepositorio;

    @Mock
    IConsultarMascotaPorNombreRepositorio consultarMascotaPorNombreRepositorio;

    @Test
    void modificarMascota_DatosCorrectos_mascotaModificada() throws ModificarMascotaException {
        Mascota mascotaAModificar = Mascota.instancia("batuque","pitbull", LocalDate.of(2019,6,15));
        Mascota mascotaDatosNuevos = Mascota.instancia("batuque","obejero belga", LocalDate.of(2019,6,15));

        when(consultarMascotaPorNombreRepositorio.findByNombre("batuque")).thenReturn(mascotaAModificar);
        when(modificarMascotaRepositorio.update(mascotaAModificar)).thenReturn(true);

        ModificarMascotaCasoUso modificarMascotaCasoUso = new ModificarMascotaCasoUso(modificarMascotaRepositorio, consultarMascotaPorNombreRepositorio);

        Mascota mascota = modificarMascotaCasoUso.modificarMascota(mascotaDatosNuevos);
        Assertions.assertEquals("obejero belga",mascota.getRaza());

    }

}
