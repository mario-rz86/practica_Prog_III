package ar.edu.undec.mascotas.casosUso;

import ar.edu.undec.mascotas.casosUso.excepciones.ModificarClienteException;
import ar.edu.undec.mascotas.casosUso.input.IModificarClienteInput;
import ar.edu.undec.mascotas.domain.Cliente;
import ar.edu.undec.mascotas.repositorio.IConsultarClientePorDniRepositorio;
import ar.edu.undec.mascotas.repositorio.IModificarClienteRepositorio;

public class ModificarClienteCasoUso implements IModificarClienteInput {

    private IModificarClienteRepositorio modificarClienteRepositorio;
    private IConsultarClientePorDniRepositorio consultarClientePorDniRepositorio;

    public ModificarClienteCasoUso(IModificarClienteRepositorio modificarClienteRepositorio, IConsultarClientePorDniRepositorio consultarClientePorDniRepositorio){
        this.modificarClienteRepositorio = modificarClienteRepositorio;
        this.consultarClientePorDniRepositorio = consultarClientePorDniRepositorio;
    }

    @Override
    public Cliente modificarCliente(Cliente clienteDatosNuevos) throws ModificarClienteException {
        Cliente clienteAModificar = consultarClientePorDniRepositorio.findByDni(clienteDatosNuevos.getDni());
        clienteAModificar.modificarDatos(clienteDatosNuevos);

        if(modificarClienteRepositorio.update(clienteAModificar)){
            return  clienteAModificar;
        }else {
            throw new ModificarClienteException();
        }
    }
}
