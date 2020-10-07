package ar.edu.undec.mascotas.casosUso.input;

import ar.edu.undec.mascotas.casosUso.excepciones.ClienteEdadMenor18Exception;
import ar.edu.undec.mascotas.casosUso.excepciones.ClienteExisteException;
import ar.edu.undec.mascotas.casosUso.excepciones.ClienteIncompletoException;
import ar.edu.undec.mascotas.domain.Cliente;

public interface ICrearClienteInput {
    boolean crearCliente (Cliente elCliente) throws ClienteIncompletoException, ClienteEdadMenor18Exception, ClienteExisteException;
}
