package pe.unjfsc.daw.spring5.app.model.dao;


import org.springframework.data.repository.CrudRepository;
import pe.unjfsc.daw.spring5.app.models.entity.Conductor;

public interface IConductorDAO extends CrudRepository<Conductor, Long>{

}
