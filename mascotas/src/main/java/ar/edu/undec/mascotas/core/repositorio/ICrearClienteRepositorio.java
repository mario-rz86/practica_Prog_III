package ar.edu.undec.mascotas.core.repositorio;

import ar.edu.undec.mascotas.core.domain.Cliente;

public interface ICrearClienteRepositorio {
    boolean existeDni(String dniCliente);

    boolean guardarCliente(Cliente cliente);

}
