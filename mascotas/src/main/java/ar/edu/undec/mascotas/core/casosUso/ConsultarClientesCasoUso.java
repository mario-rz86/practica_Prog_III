package ar.edu.undec.mascotas.core.casosUso;

import ar.edu.undec.mascotas.core.casosUso.input.IConsultarClientesInput;
import ar.edu.undec.mascotas.core.domain.Cliente;
import ar.edu.undec.mascotas.core.repositorio.IConsultarClientesRepositorio;

import java.util.Collection;

public class ConsultarClientesCasoUso implements IConsultarClientesInput {

    private IConsultarClientesRepositorio consultarClientesRepositorio;

    public ConsultarClientesCasoUso(IConsultarClientesRepositorio consultarClientesRepositorio) {
        this.consultarClientesRepositorio = consultarClientesRepositorio;
    }


    @Override
    public Collection<Cliente> ConsultarClienetes() {
        return this.consultarClientesRepositorio.findAll();
    }
}
