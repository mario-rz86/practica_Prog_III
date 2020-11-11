package ar.edu.undec.mascotas.persistencia;

import ar.edu.undec.mascotas.core.domain.Cliente;
import ar.edu.undec.mascotas.persistencia.crud.ICrearClienteCRUD;
import ar.edu.undec.mascotas.persistencia.entity.ClienteEntity;
import ar.edu.undec.mascotas.persistencia.entity.MascotaEntity;
import ar.edu.undec.mascotas.core.repositorio.ICrearClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class CrearClienteRepoImpl implements ICrearClienteRepositorio {

    @Autowired
    ICrearClienteCRUD crearClienteCRUD;

    @Override
    public boolean existeDni(String dniCliente) { return false;}

    @Override
    public boolean guardarCliente(Cliente cliente) {
        ClienteEntity clienteBD = new ClienteEntity();
        clienteBD.setNombre(cliente.getNombre());
        clienteBD.setApellido(cliente.getApellido());
        clienteBD.setDni(cliente.getDni());
        clienteBD.setFechaNacimiento(cliente.getFechaNacimiento());
        clienteBD.setMascotas(cliente.getMascotas()
                .stream()
                .map(mascota -> new MascotaEntity(  null, mascota.getNombre(), mascota.getRaza(), mascota.getFechaNacimiento(), clienteBD))
                .collect(Collectors.toList()));


        return this.crearClienteCRUD.save(clienteBD).getIdCliente()!=null;
    }
}
