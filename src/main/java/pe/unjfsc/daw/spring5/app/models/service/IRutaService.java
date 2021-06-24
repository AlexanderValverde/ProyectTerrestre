package pe.unjfsc.daw.spring5.app.models.service;

import java.util.List;

import pe.unjfsc.daw.spring5.app.models.entity.Ruta;

public interface IRutaService {
	
	public List<Ruta> findAll();

	public void save(Ruta ruta);

	public Ruta findOne(Long id);

	public void delete(Long id);
}
