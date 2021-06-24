package pe.unjfsc.daw.spring5.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import pe.unjfsc.daw.spring5.app.model.dao.IRutaDAO;
import pe.unjfsc.daw.spring5.app.models.entity.Ruta;

@Service
public class RutaServiceImpl implements IRutaService{

	@Autowired
	private IRutaDAO rutaDAO;

	@Override
	@Transactional(readOnly = true)
	public List<Ruta> findAll() {

		return (List<Ruta>) rutaDAO.findAll();
	}

	@Transactional
	@Override
	public void save(Ruta ruta) {
		rutaDAO.save(ruta);
	}

	@Transactional(readOnly = true)
	@Override
	public Ruta findOne(Long id) {

		return rutaDAO.findById(id).orElse(null);
	}

	@Transactional
	@Override
	public void delete(Long id) {
		rutaDAO.deleteById(id);

	}

}
