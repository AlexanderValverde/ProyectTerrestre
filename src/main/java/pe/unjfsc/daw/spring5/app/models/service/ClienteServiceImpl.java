package pe.unjfsc.daw.spring5.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.unjfsc.daw.spring5.app.model.dao.IClienteDAO;
import pe.unjfsc.daw.spring5.app.models.entity.Cliente;

@Service
public class ClienteServiceImpl implements IClienteService {

	@Autowired
	private IClienteDAO clienteDAO;

	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findAll() {

		return (List<Cliente>) clienteDAO.findAll();
	}

	@Transactional
	@Override
	public void save(Cliente cliente) {
		clienteDAO.save(cliente);
	}

	@Transactional(readOnly = true)
	@Override
	public Cliente findOne(Long id) {

		return clienteDAO.findById(id).orElse(null);
	}

	@Transactional
	@Override
	public void delete(Long id) {
		clienteDAO.deleteById(id);

	}

}
