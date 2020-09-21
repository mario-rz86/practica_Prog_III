package ar.edu.undec.mascotas.usecaseunittest;



import ar.edu.undec.mascotas.casosUso.CrearClienteCasoUso;
import ar.edu.undec.mascotas.casosUso.CrearMascotaCasoUso;
import ar.edu.undec.mascotas.casosUso.excepciones.ClienteIncompletoException;
import ar.edu.undec.mascotas.domain.Cliente;
import ar.edu.undec.mascotas.repositorio.ICrearClienteRepositorio;
import mockito.MockitoExtension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import java.time.LocalDate;

import static org.mockito.Mockito.when;

@ExtendWith({MockitoExtension.class})
public class CrarClienteCasoUsoTest {
    @Mock
    ICrearClienteRepositorio crearClienteRepositorio;

    @Test
    void crearCliente_clienteNoExiste_creaCliente() throws
            ClienteIncompletoException {
        //Arrange
        Cliente elCliente =  Cliente.instancia("mercado","emmanuel", "33128695",LocalDate.of(1987,1,27));
        CrearClienteCasoUso crearClienteCasoUso = new CrearClienteCasoUso(crearClienteRepositorio);

        //Simulo BD
        when(crearClienteRepositorio.existe(elCliente.getDni())).thenReturn(false);
        when(crearClienteRepositorio.guardarCliente(elCliente)).thenReturn(true);

        //Act
        boolean resultado = crearClienteCasoUso.crearCliente(elCliente);

        //Assert
        Assertions.assertTrue(resultado);
    }

    @Test
    void crearCliente_clienteExiste_noCreaCliente() throws
            ClienteIncompletoException {
        //Arrange
        Cliente elCliente =  Cliente.instancia("mercado","emmanuel", "33128695",LocalDate.of(1987,1,27));
        CrearClienteCasoUso crearClienteCasoUso = new CrearClienteCasoUso(crearClienteRepositorio);

        //Simulo BD
        when(crearClienteRepositorio.existe(elCliente.getDni())).thenReturn(false);
        when(crearClienteRepositorio.guardarCliente(elCliente)).thenReturn(false);

        //Act
        boolean resultado = crearClienteCasoUso.crearCliente(elCliente);

        //Assert
        Assertions.assertTrue(resultado);
    }

}
