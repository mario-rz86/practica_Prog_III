package ar.edu.undec.mascotas.core.repositorio;

import ar.edu.undec.mascotas.core.domain.Mascota;

public interface IConsultarMascotaPorNombreRepositorio {
    Mascota findByNombre (String nombre);
}
