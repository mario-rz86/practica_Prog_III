package ar.edu.undec.mascotas.persistencia;

import ar.edu.undec.mascotas.core.domain.Mascota;
import ar.edu.undec.mascotas.core.excepciones.MascotaIncompletaException;
import ar.edu.undec.mascotas.core.repositorio.IConsultarMascotasRepositorio;
import ar.edu.undec.mascotas.persistencia.crud.IConsultarMascotasCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;

@Repository
public class ConsultarMascotaRepoImpl implements IConsultarMascotasRepositorio {

    @Autowired
    IConsultarMascotasCRUD consultarMascotasCRUD;

    @Override
    public Collection<Mascota> findAll() {
        Collection<Mascota> mascotaCollection = new ArrayList<>();
        consultarMascotasCRUD.findAll().forEach(mascotaEntity ->
        {
            try {
                mascotaCollection.add(Mascota.instancia(mascotaEntity.getNombre(),mascotaEntity.getRaza(),mascotaEntity.getFechaNacimiento()));
            } catch (MascotaIncompletaException e) {
                e.printStackTrace();
            }
        });
        return mascotaCollection;
    }
}
