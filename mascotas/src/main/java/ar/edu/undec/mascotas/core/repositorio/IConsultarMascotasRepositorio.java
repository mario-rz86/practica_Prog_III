package ar.edu.undec.mascotas.core.repositorio;

import ar.edu.undec.mascotas.core.domain.Mascota;

import java.util.Collection;

public interface IConsultarMascotasRepositorio {
    Collection<Mascota> findAll();
}
