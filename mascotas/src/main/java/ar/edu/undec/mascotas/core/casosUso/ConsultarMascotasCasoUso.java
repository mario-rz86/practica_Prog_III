package ar.edu.undec.mascotas.core.casosUso;

import ar.edu.undec.mascotas.core.casosUso.input.IConsultarMascotasInput;
import ar.edu.undec.mascotas.core.domain.Mascota;
import ar.edu.undec.mascotas.core.repositorio.IConsultarMascotasRepositorio;

import java.util.Collection;

public class ConsultarMascotasCasoUso implements IConsultarMascotasInput {

    private IConsultarMascotasRepositorio consultarMascotasRepositorio;

    public ConsultarMascotasCasoUso(IConsultarMascotasRepositorio consultarMascotasRepositorio) {
        this.consultarMascotasRepositorio = consultarMascotasRepositorio;
    }


    @Override
    public Collection<Mascota> consultarMascotas() {
        return this.consultarMascotasRepositorio.findAll();
    }
}
