package ar.edu.undec.mascotas.repositorio;

import ar.edu.undec.mascotas.domain.Mascota;

public interface ICrearMascotaRepositorio {
    boolean existe(String nombreMascota);

    boolean guardarMascota(Mascota laMascota);
}
