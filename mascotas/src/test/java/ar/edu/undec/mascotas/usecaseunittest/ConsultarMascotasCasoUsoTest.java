package ar.edu.undec.mascotas.usecaseunittest;

import ar.edu.undec.mascotas.core.casosUso.ConsultarMascotasCasoUso;
import ar.edu.undec.mascotas.core.excepciones.MascotaIncompletaException;
import ar.edu.undec.mascotas.core.domain.Mascota;
import ar.edu.undec.mascotas.core.repositorio.IConsultarMascotasRepositorio;
import mockito.MockitoExtension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static org.mockito.Mockito.when;

@ExtendWith({MockitoExtension.class})
public class ConsultarMascotasCasoUsoTest {

    @Mock
    IConsultarMascotasRepositorio consultarMascotasRepositorio;

    @Test
    public void consultarMascotas_ExistenMascotas_DevuelveLista() throws MascotaIncompletaException {

        ConsultarMascotasCasoUso consultarMascotasCasoUso = new ConsultarMascotasCasoUso(consultarMascotasRepositorio);
        when(consultarMascotasRepositorio.findAll()).thenReturn(Collections.singletonList(Mascota.instancia("terry","bull terrier", LocalDate.of(2012,02,3))));

        Collection<Mascota> mascotaList = consultarMascotasCasoUso.consultarMascotas();

        Assertions.assertNotEquals(0, mascotaList.size());

    }

    @Test
    public void consultarMascotas_NoExistenMascotas_DevuelveListaVacia() throws MascotaIncompletaException {

        ConsultarMascotasCasoUso consultarMascotasCasoUso = new ConsultarMascotasCasoUso(consultarMascotasRepositorio);
        when(consultarMascotasRepositorio.findAll()).thenReturn(new ArrayList<>());

        Collection<Mascota> mascotaList = consultarMascotasCasoUso.consultarMascotas();

        Assertions.assertEquals(0, mascotaList.size());

    }
    /*
    List<Mascota> factoryMascotas() {
        List<Mascota> mascotas = new ArrayList<>();
        try {
            mascotas.add(Mascota.instancia("terry","bull terrier", LocalDate.of(2012,02,3)));
            mascotas.add(Mascota.instancia("marshall","dalmata",LocalDate.of(2017,04,04)));
        } catch (MascotaIncompletaException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mascotas;
    }*/


}
