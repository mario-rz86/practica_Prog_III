package ar.edu.undec.mascotas.repositorio;

import ar.edu.undec.mascotas.domain.Cliente;

public interface ICrearClienteRepositorio {
    boolean existe(String dniCliente);

    boolean guardarCliente(Cliente cliente);

}
