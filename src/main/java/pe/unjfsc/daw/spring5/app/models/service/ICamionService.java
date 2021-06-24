package pe.unjfsc.daw.spring5.app.models.service;

import java.util.List;

import pe.unjfsc.daw.spring5.app.models.entity.Camion;

public interface ICamionService {

	public List<Camion> findAll();

	public void save(Camion camion);

	public Camion findOne(Long id);

	public void delete(Long id);
}
