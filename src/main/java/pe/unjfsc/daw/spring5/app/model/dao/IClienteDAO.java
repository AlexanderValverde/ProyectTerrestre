package pe.unjfsc.daw.spring5.app.model.dao;



import org.springframework.data.repository.CrudRepository;


import pe.unjfsc.daw.spring5.app.models.entity.Cliente;

public interface IClienteDAO extends CrudRepository<Cliente, Long>{


}
