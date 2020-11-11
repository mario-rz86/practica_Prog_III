package ar.edu.undec.mascotas.core.casosUso;

import ar.edu.undec.mascotas.core.excepciones.ClienteExisteException;
import ar.edu.undec.mascotas.core.casosUso.input.ICrearClienteInput;
import ar.edu.undec.mascotas.core.domain.Cliente;
import ar.edu.undec.mascotas.core.repositorio.ICrearClienteRepositorio;

public class CrearClienteCasoUso implements ICrearClienteInput {

    private ICrearClienteRepositorio crearClienteRepositorio;

    public CrearClienteCasoUso(ICrearClienteRepositorio crearClienteRepositorio) {
        this.crearClienteRepositorio = crearClienteRepositorio;
    }

    @Override
    public boolean crearCliente(Cliente elCliente) throws ClienteExisteException {
        if(crearClienteRepositorio.existeDni(elCliente.getDni())) {
            throw new ClienteExisteException();
        }
        else {
            crearClienteRepositorio.guardarCliente(elCliente);
            return true;
        }
    }
}
