package ar.edu.undec.mascotas.usecaseunittest;

import ar.edu.undec.mascotas.casosUso.ConsultarClientesCasoUso;
import ar.edu.undec.mascotas.casosUso.excepciones.ClienteIncompletoException;
import ar.edu.undec.mascotas.casosUso.excepciones.MascotaIncompletaException;
import ar.edu.undec.mascotas.domain.Cliente;
import ar.edu.undec.mascotas.domain.Mascota;
import ar.edu.undec.mascotas.repositorio.IConsultarClientesRepositorio;
import ar.edu.undec.mascotas.repositorio.IConsultarMascotasRepositorio;
import mockito.MockitoExtension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith({MockitoExtension.class})
public class ConsultarClientesCasoUsoTest {
    @Mock
    IConsultarClientesRepositorio consultarClientesRepositorio;
    //IConsultarMascotasRepositorio consultarMascotasRepositorio;

    public ConsultarClientesCasoUsoTest() throws MascotaIncompletaException {
    }

    @Test
    public void consultarClientes_ExistenClientes_DevuelveLista(){

        when(consultarClientesRepositorio.findAll()).thenReturn(factoryClientes());
        ConsultarClientesCasoUso consultarClientesCasoUso = new ConsultarClientesCasoUso(consultarClientesRepositorio);

        List<Cliente> clientesConsultados = (List<Cliente>) consultarClientesCasoUso.ConsultarClienetes();
        Assertions.assertEquals(2, clientesConsultados.size());

    }
    Mascota laMascota1 =  Mascota.instancia("toby","callejero", LocalDate.of(2005,1,1));
    Mascota laMascota2 =  Mascota.instancia("batuque","caniche", LocalDate.of(2013,5,12));
    List<Cliente> factoryClientes() {

        List<Mascota> mascotaList1 =Collections.singletonList(laMascota1);
        List<Mascota> mascotaList2 =Collections.singletonList(laMascota2);
        List<Cliente> clientes = new ArrayList<>();
        try {
            clientes.add(Cliente.instancia("mercado","emmanuel", "32128133", LocalDate.of(1987,1,27), mascotaList1));
            clientes.add(Cliente.instancia("rodriguez","ricardo","35064698", LocalDate.of(1990,7,23), mascotaList2));
        } catch (ClienteIncompletoException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return clientes;
    }

}
