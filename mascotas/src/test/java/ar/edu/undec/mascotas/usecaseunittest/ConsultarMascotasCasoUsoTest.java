package ar.edu.undec.mascotas.usecaseunittest;

import ar.edu.undec.mascotas.casosUso.ConsultarMascotasCasoUso;
import ar.edu.undec.mascotas.casosUso.excepciones.MascotaIncompletaException;
import ar.edu.undec.mascotas.domain.Mascota;
import ar.edu.undec.mascotas.repositorio.IConsultarMascotasRepositorio;
import mockito.MockitoExtension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith({MockitoExtension.class})
public class ConsultarMascotasCasoUsoTest {

    @Mock
    IConsultarMascotasRepositorio consultarMascotasRepositorio;

    @Test
    public void consultarMascotas_ExistenMascotas_DevuelveLista(){

        when(consultarMascotasRepositorio.findAll()).thenReturn(factoryCuentas());
        ConsultarMascotasCasoUso consultarMascotasCasoUso = new ConsultarMascotasCasoUso(consultarMascotasRepositorio);

        List<Mascota> mascotasConsultadas = (List<Mascota>) consultarMascotasCasoUso.ConsultarCeuntas();
        Assertions.assertEquals(2, mascotasConsultadas.size());

    }

    List<Mascota> factoryCuentas() {
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
    }


}
