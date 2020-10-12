package ar.edu.undec.mascotas.persistencetest;


import ar.edu.undec.mascotas.casosUso.excepciones.ClienteIncompletoException;
import ar.edu.undec.mascotas.casosUso.excepciones.MascotaIncompletaException;
import ar.edu.undec.mascotas.domain.Cliente;
import ar.edu.undec.mascotas.domain.Mascota;
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

        Mascota laMascota =  Mascota.instancia("marshal","dalmata", LocalDate.of(2017,5,14));
        List<Mascota> mascotaList = Collections.singletonList(laMascota);
        Cliente elCliente =  Cliente.instancia("rodriguez","bautista", "40123654",LocalDate.of(1995,4,4), mascotaList);

        boolean resultado = crearClienteRepo.guardarCliente(elCliente);
        Assertions.assertTrue(resultado);

    }

}
