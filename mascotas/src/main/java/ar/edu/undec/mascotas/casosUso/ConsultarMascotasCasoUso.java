package ar.edu.undec.mascotas.casosUso;

import ar.edu.undec.mascotas.casosUso.input.IConsultarMascotasInput;
import ar.edu.undec.mascotas.domain.Mascota;
import ar.edu.undec.mascotas.repositorio.IConsultarMascotasRepositorio;

import java.util.Collection;

public class ConsultarMascotasCasoUso implements IConsultarMascotasInput {

    private IConsultarMascotasRepositorio consultarMascotasRepositorio;

    public ConsultarMascotasCasoUso(IConsultarMascotasRepositorio consultarMascotasRepositorio) {
        this.consultarMascotasRepositorio = consultarMascotasRepositorio;
    }


    @Override
    public Collection<Mascota> ConsultarMascotas() {
        return this.consultarMascotasRepositorio.findAll();
    }
}
