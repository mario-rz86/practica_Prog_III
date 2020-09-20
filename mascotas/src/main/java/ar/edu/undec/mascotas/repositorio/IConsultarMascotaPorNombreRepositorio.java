package ar.edu.undec.mascotas.repositorio;

import ar.edu.undec.mascotas.domain.Mascota;

public interface IConsultarMascotaPorNombreRepositorio {
    Mascota findByNombre (String nombre);
}
