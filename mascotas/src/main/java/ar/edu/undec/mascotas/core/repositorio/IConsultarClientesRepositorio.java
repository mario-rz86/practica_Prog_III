package ar.edu.undec.mascotas.core.repositorio;

import ar.edu.undec.mascotas.core.domain.Cliente;

import java.util.Collection;

public interface IConsultarClientesRepositorio {
    Collection<Cliente> findAll();
}
