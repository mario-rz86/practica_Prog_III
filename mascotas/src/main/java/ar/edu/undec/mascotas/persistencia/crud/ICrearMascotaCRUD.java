package ar.edu.undec.mascotas.persistencia.crud;

import ar.edu.undec.mascotas.persistencia.entity.MascotaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICrearMascotaCRUD extends CrudRepository<MascotaEntity,Integer> {

    boolean existsByNombre(String nombreM);

}
