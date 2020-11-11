package ar.edu.undec.mascotas.persistencetest;


import ar.edu.undec.mascotas.core.excepciones.ClienteIncompletoException;
import ar.edu.undec.mascotas.core.excepciones.MascotaIncompletaException;
import ar.edu.undec.mascotas.core.domain.Cliente;
import ar.edu.undec.mascotas.core.domain.Mascota;
import ar.edu.undec.mascotas.persistencia.CrearClienteRepoImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@SpringBootTest
public class CrearClienteDataTest {

    @Autowired
    CrearClienteRepoImpl crearClienteRepo;


    @Test
    public void testCrearCliente() throws ClienteIncompletoException, MascotaIncompletaException {

        Mascota laMascota =  Mascota.instancia("marshal","dalmata", LocalDate.of(2015,3,16));
        List<Mascota> mascotaList = Collections.singletonList(laMascota);
        Cliente elCliente =  Cliente.instancia("perez","juan", "43125695",LocalDate.of(1999,6,14), mascotaList);

        boolean resultado = crearClienteRepo.guardarCliente(elCliente);

        Assertions.assertTrue(resultado);


    }

}
