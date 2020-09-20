package ar.edu.undec.mascotas.casosUso.input;

import ar.edu.undec.mascotas.casosUso.excepciones.ModificarMascotaException;
import ar.edu.undec.mascotas.domain.Mascota;

public interface IModificarMascotaInput {
    Mascota modificarMascota(Mascota mascotaDatosNuevos) throws ModificarMascotaException;
}
