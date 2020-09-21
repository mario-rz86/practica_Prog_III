package ar.edu.undec.mascotas.repositorio;

import ar.edu.undec.mascotas.domain.Cliente;

public interface IModificarClienteRepositorio {
    boolean update(Cliente elCliente);
}
