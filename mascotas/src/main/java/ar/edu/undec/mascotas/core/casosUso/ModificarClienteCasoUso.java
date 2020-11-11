package ar.edu.undec.mascotas.core.casosUso;

import ar.edu.undec.mascotas.core.excepciones.ModificarClienteException;
import ar.edu.undec.mascotas.core.casosUso.input.IModificarClienteInput;
import ar.edu.undec.mascotas.core.domain.Cliente;
import ar.edu.undec.mascotas.core.repositorio.IConsultarClientePorDniRepositorio;
import ar.edu.undec.mascotas.core.repositorio.IModificarClienteRepositorio;

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
