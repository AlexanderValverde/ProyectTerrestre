package pe.unjfsc.daw.spring5.app.model.dao;



import org.springframework.data.repository.CrudRepository;

import pe.unjfsc.daw.spring5.app.models.entity.Camion;


public interface ICamionDAO extends CrudRepository<Camion, Long>{
	

}
