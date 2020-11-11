package ar.edu.undec.mascotas.core.repositorio;

import ar.edu.undec.mascotas.core.domain.Cliente;

public interface IModificarClienteRepositorio {
    boolean update(Cliente elCliente);
}
