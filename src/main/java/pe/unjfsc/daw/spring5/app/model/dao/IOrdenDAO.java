package pe.unjfsc.daw.spring5.app.model.dao;

import org.springframework.data.repository.CrudRepository;

import pe.unjfsc.daw.spring5.app.models.entity.Orden;

public interface IOrdenDAO extends CrudRepository<Orden, Long>{

}
