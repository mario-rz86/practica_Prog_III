package ar.edu.undec.mascotas.repositorio;

import ar.edu.undec.mascotas.domain.Cliente;

import java.util.Collection;

public interface IConsultarClientesRepositorio {
    Collection<Cliente> findAll();
}
