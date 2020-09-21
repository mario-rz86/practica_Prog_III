package ar.edu.undec.mascotas.casosUso;

import ar.edu.undec.mascotas.casosUso.input.ICrearClienteInput;
import ar.edu.undec.mascotas.domain.Cliente;
import ar.edu.undec.mascotas.repositorio.ICrearClienteRepositorio;

public class CrearClienteCasoUso implements ICrearClienteInput {

    private ICrearClienteRepositorio crearClienteRepositorio;

    public CrearClienteCasoUso(ICrearClienteRepositorio crearClienteRepositorio) {
        this.crearClienteRepositorio = crearClienteRepositorio;
    }

    @Override
    public boolean crearCliente(Cliente elCliente) {
        if(crearClienteRepositorio.existe(elCliente.getDni())) {
            return false;
        }
        else {
            crearClienteRepositorio.guardarCliente(elCliente);
            return true;
        }
    }
}
