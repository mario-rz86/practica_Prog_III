package ar.edu.undec.mascotas.persistencia;

import ar.edu.undec.mascotas.domain.Cliente;
import ar.edu.undec.mascotas.persistencia.crud.ICrearClienteCRUD;
import ar.edu.undec.mascotas.persistencia.entity.ClienteEntity;
import ar.edu.undec.mascotas.repositorio.ICrearClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CrearClienteRepoImpl implements ICrearClienteRepositorio {

    @Autowired
    ICrearClienteCRUD crearClienteCRUD;

    @Override
    public boolean existe(String dniCliente) { return false;}

    @Override
    public boolean guardarCliente(Cliente cliente) {
        ClienteEntity clienteBD = new ClienteEntity();
        clienteBD.setNombre(cliente.getNombre());
        clienteBD.setApellido(cliente.getApellido());
        clienteBD.setDni(cliente.getDni());
        clienteBD.setFechaNacimiento(cliente.getFechaNacimiento());
        clienteBD.setMascotas(clienteBD.getMascotas());

        return this.crearClienteCRUD.save(clienteBD).getIdCliente()!=null;
    }
}
