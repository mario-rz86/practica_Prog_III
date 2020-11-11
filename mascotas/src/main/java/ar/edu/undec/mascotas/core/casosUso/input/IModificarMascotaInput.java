package ar.edu.undec.mascotas.core.casosUso.input;

import ar.edu.undec.mascotas.core.excepciones.ModificarMascotaException;
import ar.edu.undec.mascotas.core.domain.Mascota;

public interface IModificarMascotaInput {
    Mascota modificarMascota(Mascota mascotaDatosNuevos) throws ModificarMascotaException;
}
