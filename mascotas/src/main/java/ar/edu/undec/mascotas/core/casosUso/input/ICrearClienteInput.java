package ar.edu.undec.mascotas.core.casosUso.input;

import ar.edu.undec.mascotas.core.excepciones.ClienteEdadMenor18Exception;
import ar.edu.undec.mascotas.core.excepciones.ClienteExisteException;
import ar.edu.undec.mascotas.core.excepciones.ClienteIncompletoException;
import ar.edu.undec.mascotas.core.domain.Cliente;

public interface ICrearClienteInput {
    boolean crearCliente (Cliente elCliente) throws ClienteIncompletoException, ClienteEdadMenor18Exception, ClienteExisteException;
}
