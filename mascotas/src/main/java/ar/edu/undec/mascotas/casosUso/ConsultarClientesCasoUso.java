package ar.edu.undec.mascotas.casosUso;

import ar.edu.undec.mascotas.casosUso.input.IConsultarClientesInput;
import ar.edu.undec.mascotas.domain.Cliente;
import ar.edu.undec.mascotas.repositorio.IConsultarClientesRepositorio;

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
