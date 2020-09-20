package ar.edu.undec.mascotas.casosUso;

import ar.edu.undec.mascotas.casosUso.excepciones.ModificarMascotaException;
import ar.edu.undec.mascotas.casosUso.input.IModificarMascotaInput;
import ar.edu.undec.mascotas.domain.Mascota;
import ar.edu.undec.mascotas.repositorio.IConsultarMascotaPorNombreRepositorio;
import ar.edu.undec.mascotas.repositorio.IModificarMascotaRepositorio;

public class ModificarMascotaCasoUso implements IModificarMascotaInput {

    private IModificarMascotaRepositorio modificarMascotaRepositorio;
    private IConsultarMascotaPorNombreRepositorio consultarMascotaPorNombreRepositorio;

    public ModificarMascotaCasoUso(IModificarMascotaRepositorio modificarMascotaRepositorio, IConsultarMascotaPorNombreRepositorio consultarMascotaPorNombreRepositorio){
        this.modificarMascotaRepositorio = modificarMascotaRepositorio;
        this.consultarMascotaPorNombreRepositorio = consultarMascotaPorNombreRepositorio;
    }

    @Override
    public Mascota modificarMascota(Mascota mascotaDatosNuevos) throws ModificarMascotaException {
        Mascota mascotaAModificar = consultarMascotaPorNombreRepositorio.findByNombre(mascotaDatosNuevos.getNombre());
        mascotaAModificar.modificarDatos(mascotaDatosNuevos);

        if(modificarMascotaRepositorio.update(mascotaAModificar)){
            return  mascotaAModificar;
        }else {
            throw new ModificarMascotaException();
        }
    }
}
