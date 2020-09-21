package ar.edu.undec.mascotas.casosUso.input;

import ar.edu.undec.mascotas.casosUso.excepciones.ModificarClienteException;
import ar.edu.undec.mascotas.domain.Cliente;

public interface IModificarClienteInput {
    Cliente modificarCliente(Cliente clienteDatosNuevos) throws ModificarClienteException;

}
