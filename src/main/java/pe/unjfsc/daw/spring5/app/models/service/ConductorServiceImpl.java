package pe.unjfsc.daw.spring5.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.unjfsc.daw.spring5.app.model.dao.IConductorDAO;
import pe.unjfsc.daw.spring5.app.models.entity.Conductor;

@Service
public class ConductorServiceImpl implements IConductorService {

	@Autowired
	private IConductorDAO conductorDAO;

	@Transactional(readOnly = true)
	@Override
	public List<Conductor> findAll() {

		return (List<Conductor>) conductorDAO.findAll();
	}

	@Transactional
	@Override
	public void save(Conductor conductor) {

		conductorDAO.save(conductor);

	}

	@Transactional(readOnly = true)
	@Override
	public Conductor findOne(Long id) {

		return conductorDAO.findById(id).orElse(null);
	}

	@Transactional
	@Override
	public void delete(Long id) {

		conductorDAO.deleteById(id);
	}

}
