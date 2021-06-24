package pe.unjfsc.daw.spring5.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.unjfsc.daw.spring5.app.model.dao.ICamionDAO;
import pe.unjfsc.daw.spring5.app.models.entity.Camion;

@Service
public class CamionServiceImpl implements ICamionService {

	@Autowired
	private ICamionDAO camionDAO;

	@Override
	@Transactional(readOnly = true)
	public List<Camion> findAll() {

		return (List<Camion>) camionDAO.findAll();
	}

	@Transactional
	@Override
	public void save(Camion camion) {
		camionDAO.save(camion);
	}

	@Transactional(readOnly = true)
	@Override
	public Camion findOne(Long id) {

		return camionDAO.findById(id).orElse(null);
	}

	@Transactional
	@Override
	public void delete(Long id) {
		camionDAO.deleteById(id);

	}

}
