package pe.unjfsc.daw.spring5.app.models.service;

import java.util.List;

import pe.unjfsc.daw.spring5.app.models.entity.Conductor;

public interface IConductorService {

	public List<Conductor> findAll();

	public void save(Conductor conductor);

	public Conductor findOne(Long id);

	public void delete(Long id);
}
