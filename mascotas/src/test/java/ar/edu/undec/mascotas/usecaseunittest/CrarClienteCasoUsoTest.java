package ar.edu.undec.mascotas.usecaseunittest;



import ar.edu.undec.mascotas.core.casosUso.CrearClienteCasoUso;
import ar.edu.undec.mascotas.core.excepciones.ClienteExisteException;
import ar.edu.undec.mascotas.core.excepciones.ClienteIncompletoException;
import ar.edu.undec.mascotas.core.excepciones.MascotaIncompletaException;
import ar.edu.undec.mascotas.core.domain.Cliente;
import ar.edu.undec.mascotas.core.domain.Mascota;
import ar.edu.undec.mascotas.core.repositorio.ICrearClienteRepositorio;
import mockito.MockitoExtension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith({MockitoExtension.class})
public class CrarClienteCasoUsoTest {
    @Mock
    ICrearClienteRepositorio crearClienteRepositorio;

    @Test
    void crearCliente_clienteNoExiste_creaCliente() throws
            ClienteIncompletoException, ClienteExisteException, MascotaIncompletaException {
        //Arrange
        Mascota laMascota =  Mascota.instancia("toby","callejero", LocalDate.of(2005,1,1));
        List<Mascota> mascotaList =Collections.singletonList(laMascota);
        Cliente elCliente =  Cliente.instancia("mercado", "emmanuel", "33128695", LocalDate.of(1987, 1, 27), mascotaList);
        CrearClienteCasoUso crearClienteCasoUso = new CrearClienteCasoUso(crearClienteRepositorio);

        //Simulo BD
        when(crearClienteRepositorio.existeDni(elCliente.getDni())).thenReturn(false);
        when(crearClienteRepositorio.guardarCliente(elCliente)).thenReturn(true);

        //Act
        boolean resultado = crearClienteCasoUso.crearCliente(elCliente);

        //Assert
        Assertions.assertTrue(resultado);
    }

    @Test
    void crearCliente_clienteExiste_noCreaCliente() throws
            ClienteIncompletoException, MascotaIncompletaException {
        //Arrange
        Mascota laMascota =  Mascota.instancia("toby","callejero", LocalDate.of(2005,1,1));
        List<Mascota> mascotaList =Collections.singletonList(laMascota);
        Cliente elCliente =  Cliente.instancia("mercado","emmanuel", "33128695",LocalDate.of(1987,1,27), mascotaList);
        CrearClienteCasoUso crearClienteCasoUso = new CrearClienteCasoUso(crearClienteRepositorio);

        //Simulo BD
        when(crearClienteRepositorio.existeDni(elCliente.getDni())).thenReturn(true);



        //Act & Assert
        Assertions.assertThrows(ClienteExisteException.class,()->crearClienteCasoUso.crearCliente(elCliente));
    }

}
