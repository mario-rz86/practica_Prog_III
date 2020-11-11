package ar.edu.undec.mascotas.core.casosUso.input;

import ar.edu.undec.mascotas.core.excepciones.ModificarClienteException;
import ar.edu.undec.mascotas.core.domain.Cliente;

public interface IModificarClienteInput {
    Cliente modificarCliente(Cliente clienteDatosNuevos) throws ModificarClienteException;

}
