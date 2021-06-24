package pe.unjfsc.daw.spring5.app.models.service;

import java.util.List;

import pe.unjfsc.daw.spring5.app.models.entity.Orden;
import pe.unjfsc.daw.spring5.app.models.entity.Ruta;
import pe.unjfsc.daw.spring5.app.models.entity.Cliente;
import pe.unjfsc.daw.spring5.app.models.entity.Conductor;
import pe.unjfsc.daw.spring5.app.models.entity.Camion;

public interface IOrdenService {

	public List<Orden> findAll();

	public void save(Orden orden);

	public Orden findOne(Long id);

	public void delete(Long id);
	
	public List<Ruta> findAllRuta();
	public List<Cliente> findAllCliente();
	public List<Camion> findAllCamion();
	public List<Conductor> findAllConductor();
	
//	public Ruta findOneRuta(Long id);
//	public Cliente findOneCliente(Long id);
//	public Camion findOneCamion(Long id);
//	public Conductor findOneConductor(Long id);
}
