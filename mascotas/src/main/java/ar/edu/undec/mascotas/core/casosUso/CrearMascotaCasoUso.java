package ar.edu.undec.mascotas.core.casosUso;

import ar.edu.undec.mascotas.core.excepciones.MascotaExisteException;
import ar.edu.undec.mascotas.core.casosUso.input.ICrearMascotaInput;
import ar.edu.undec.mascotas.core.domain.Mascota;
import ar.edu.undec.mascotas.core.repositorio.ICrearMascotaRepositorio;

public class CrearMascotaCasoUso implements ICrearMascotaInput{
    private ICrearMascotaRepositorio crearMascotaRepositorio;

    public CrearMascotaCasoUso(ICrearMascotaRepositorio crearMascotaRepositorio) {

        this.crearMascotaRepositorio = crearMascotaRepositorio;
    }


    @Override
    public boolean crearMascota(Mascota laMascota) throws MascotaExisteException {
        if(crearMascotaRepositorio.existe(laMascota.getNombre())) {
            throw new MascotaExisteException();
        }
        else {
            crearMascotaRepositorio.guardarMascota(laMascota);
            return true;
        }

    }
}
