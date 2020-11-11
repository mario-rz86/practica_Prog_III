package ar.edu.undec.mascotas.core.casosUso.input;

import ar.edu.undec.mascotas.core.excepciones.MascotaExisteException;
import ar.edu.undec.mascotas.core.excepciones.MascotaIncompletaException;
import ar.edu.undec.mascotas.core.domain.Mascota;

public interface ICrearMascotaInput {
    boolean crearMascota(Mascota laMascota) throws MascotaIncompletaException, MascotaExisteException;
}
