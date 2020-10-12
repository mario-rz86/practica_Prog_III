package ar.edu.undec.mascotas.persistencia.crud;

import ar.edu.undec.mascotas.persistencia.entity.ClienteEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICrearClienteCRUD extends CrudRepository<ClienteEntity,Integer> {
}
