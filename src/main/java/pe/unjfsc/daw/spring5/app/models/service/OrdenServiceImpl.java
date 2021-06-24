package pe.unjfsc.daw.spring5.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.unjfsc.daw.spring5.app.model.dao.IOrdenDAO;
import pe.unjfsc.daw.spring5.app.model.dao.IRutaDAO;
import pe.unjfsc.daw.spring5.app.model.dao.ICamionDAO;
import pe.unjfsc.daw.spring5.app.model.dao.IClienteDAO;
import pe.unjfsc.daw.spring5.app.model.dao.IConductorDAO;
import pe.unjfsc.daw.spring5.app.models.entity.Camion;
import pe.unjfsc.daw.spring5.app.models.entity.Cliente;
import pe.unjfsc.daw.spring5.app.models.entity.Conductor;
import pe.unjfsc.daw.spring5.app.models.entity.Orden;
import pe.unjfsc.daw.spring5.app.models.entity.Ruta;

@Service
public class OrdenServiceImpl implements IOrdenService {

	@Autowired
	private IOrdenDAO ordenDAO;
	
	@Autowired
	private IRutaDAO rutaDAO;
	@Autowired
	private IClienteDAO clienteDAO;
	@Autowired
	private ICamionDAO camionDAO;
	@Autowired
	private IConductorDAO conductorDAO;
	
	@Override
	@Transactional(readOnly = true)
	public List<Orden> findAll() {
		// TODO Auto-generated method stub
		return (List<Orden>) ordenDAO.findAll();
	}

	@Override
	@Transactional
	public void save(Orden orden) {
		ordenDAO.save(orden);

	}

	@Override
	@Transactional(readOnly = true)
	public Orden findOne(Long id) {
		
		return ordenDAO.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		ordenDAO.deleteById(id);

	}

	@Override
	@Transactional(readOnly = true)
	public List<Ruta> findAllRuta() {
		// TODO Auto-generated method stub
		return (List<Ruta>) rutaDAO.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findAllCliente() {
		return (List<Cliente>) clienteDAO.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Camion> findAllCamion() {
		return (List<Camion>) camionDAO.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Conductor> findAllConductor() {
		return (List<Conductor>) conductorDAO.findAll();
	}

//	@Override
//	public Ruta findOneRuta(Long id) {
//		return rutaDAO.findById(id).orElse(null);
//	}
//
//	@Override
//	public Cliente findOneCliente(Long id) {
//		return clienteDAO.findById(id).orElse(null);
//	}
//
//	@Override
//	public Camion findOneCamion(Long id) {
//		return camionDAO.findById(id).orElse(null);
//	}
//
//	@Override
//	public Conductor findOneConductor(Long id) {
//		return conductorDAO.findById(id).orElse(null);
//	}

}
