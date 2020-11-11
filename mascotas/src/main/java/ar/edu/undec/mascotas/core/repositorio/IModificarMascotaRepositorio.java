package ar.edu.undec.mascotas.core.repositorio;

import ar.edu.undec.mascotas.core.domain.Mascota;

public interface IModificarMascotaRepositorio {
    boolean update(Mascota laMascota);
}
