package ar.edu.undec.mascotas.core.repositorio;

import ar.edu.undec.mascotas.core.domain.Mascota;

public interface ICrearMascotaRepositorio {
    boolean existe(String nombreMascota);

    boolean guardarMascota(Mascota laMascota);
}
