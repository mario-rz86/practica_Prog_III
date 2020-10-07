package ar.edu.undec.mascotas.casosUso.input;

import ar.edu.undec.mascotas.casosUso.excepciones.MascotaExisteException;
import ar.edu.undec.mascotas.casosUso.excepciones.MascotaIncompletaException;
import ar.edu.undec.mascotas.domain.Mascota;

public interface ICrearMascotaInput {
    boolean crearMascota(Mascota laMascota) throws MascotaIncompletaException, MascotaExisteException;
}
