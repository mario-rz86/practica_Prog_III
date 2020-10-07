package ar.edu.undec.mascotas.casosUso;

import ar.edu.undec.mascotas.casosUso.excepciones.ClienteExisteException;
import ar.edu.undec.mascotas.casosUso.excepciones.MascotaExisteException;
import ar.edu.undec.mascotas.casosUso.input.ICrearClienteInput;
import ar.edu.undec.mascotas.domain.Cliente;
import ar.edu.undec.mascotas.repositorio.ICrearClienteRepositorio;

import java.time.LocalDate;

public class CrearClienteCasoUso implements ICrearClienteInput {

    private ICrearClienteRepositorio crearClienteRepositorio;

    public CrearClienteCasoUso(ICrearClienteRepositorio crearClienteRepositorio) {
        this.crearClienteRepositorio = crearClienteRepositorio;
    }

    @Override
    public boolean crearCliente(Cliente elCliente) throws ClienteExisteException {
        if(crearClienteRepositorio.existe(elCliente.getDni())) {
            throw new ClienteExisteException();
        }
        else {
            crearClienteRepositorio.guardarCliente(elCliente);
            return true;
        }
    }
}
