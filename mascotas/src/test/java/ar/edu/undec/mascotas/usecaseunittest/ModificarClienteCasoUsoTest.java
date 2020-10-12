package ar.edu.undec.mascotas.usecaseunittest;

import ar.edu.undec.mascotas.casosUso.ModificarClienteCasoUso;
import ar.edu.undec.mascotas.casosUso.excepciones.ClienteIncompletoException;
import ar.edu.undec.mascotas.casosUso.excepciones.MascotaIncompletaException;
import ar.edu.undec.mascotas.casosUso.excepciones.ModificarClienteException;
import ar.edu.undec.mascotas.domain.Cliente;
import ar.edu.undec.mascotas.domain.Mascota;
import ar.edu.undec.mascotas.repositorio.IConsultarClientePorDniRepositorio;
import ar.edu.undec.mascotas.repositorio.IModificarClienteRepositorio;
import mockito.MockitoExtension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith({MockitoExtension.class})
public class ModificarClienteCasoUsoTest {

    @Mock
    IModificarClienteRepositorio modificarClienteRepositorio;

    @Mock
    IConsultarClientePorDniRepositorio consultarClientePorDniRepositorio;


    Mascota laMascota1 =  Mascota.instancia("toby","callejero", LocalDate.of(2005,1,1));
    Mascota laMascota2 =  Mascota.instancia("toby","caniche", LocalDate.of(2005,1,1));

    public ModificarClienteCasoUsoTest() throws MascotaIncompletaException {
    }

    @Test
    void modificarCliente_DatosCorrectos_clienteModificado() throws ModificarClienteException, ClienteIncompletoException {
        List<Mascota> mascotaList1 = Collections.singletonList(laMascota1);
        List<Mascota> mascotaList2 =Collections.singletonList(laMascota2);
        Cliente clienteAModificar = Cliente.instancia("mercado","emmanuel", "32454789", LocalDate.of(1988,1,27), mascotaList1);
        Cliente clienteDatosNuevos = Cliente.instancia("mercado","carlin", "32454789", LocalDate.of(1988,1,23), mascotaList2);

        when(consultarClientePorDniRepositorio.findByDni("35064698")).thenReturn(clienteAModificar);
        when(modificarClienteRepositorio.update(clienteAModificar)).thenReturn(true);

        ModificarClienteCasoUso modificarClienteCasoUso = new ModificarClienteCasoUso (modificarClienteRepositorio, consultarClientePorDniRepositorio);

        Cliente cliente = modificarClienteCasoUso.modificarCliente(clienteDatosNuevos);
        Assertions.assertEquals("35064698",cliente.getDni());

    }

}
