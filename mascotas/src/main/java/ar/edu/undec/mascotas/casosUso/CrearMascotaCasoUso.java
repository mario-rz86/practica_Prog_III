package ar.edu.undec.mascotas.casosUso;

import ar.edu.undec.mascotas.casosUso.excepciones.MascotaExisteException;
import ar.edu.undec.mascotas.casosUso.input.ICrearMascotaInput;
import ar.edu.undec.mascotas.domain.Mascota;
import ar.edu.undec.mascotas.repositorio.ICrearMascotaRepositorio;

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
