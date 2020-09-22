package ar.edu.undec.mascotas.usecaseunittest;

import ar.edu.undec.mascotas.casosUso.ConsultarClientesCasoUso;
import ar.edu.undec.mascotas.casosUso.excepciones.ClienteIncompletoException;
import ar.edu.undec.mascotas.domain.Cliente;
import ar.edu.undec.mascotas.repositorio.IConsultarClientesRepositorio;
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
public class ConsultarClientesCasoUsoTest {
    @Mock
    IConsultarClientesRepositorio consultarClientesRepositorio;

    @Test
    public void consultarClientes_ExistenClientes_DevuelveLista(){

        when(consultarClientesRepositorio.findAll()).thenReturn(factoryClientes());
        ConsultarClientesCasoUso consultarClientesCasoUso = new ConsultarClientesCasoUso(consultarClientesRepositorio);

        List<Cliente> clientesConsultados = (List<Cliente>) consultarClientesCasoUso.ConsultarClienetes();
        Assertions.assertEquals(2, clientesConsultados.size());

    }

    List<Cliente> factoryClientes() {
        List<Cliente> clientes = new ArrayList<>();
        try {
            clientes.add(Cliente.instancia("mercado","emmanuel", "32128133", LocalDate.of(1987,1,27)));
            clientes.add(Cliente.instancia("rodriguez","ricardo","35064698", LocalDate.of(1990,7,23)));
        } catch (ClienteIncompletoException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return clientes;
    }

}
