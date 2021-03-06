package pe.unjfsc.daw.spring5.app.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import pe.unjfsc.daw.spring5.app.models.entity.Cliente;
import pe.unjfsc.daw.spring5.app.models.service.IClienteService;

@Controller
@SessionAttributes("cliente")
public class ClienteController {

	@Autowired
	private IClienteService clienteService;

	@GetMapping(value = "/listcliente")
	public String listar(Model model) {

		model.addAttribute("titulo", "Listado de clientes");
		model.addAttribute("clientes", clienteService.findAll());
		return "listcliente";
	}

	@GetMapping(value = "/formcliente")
	public String crear(Map<String, Object> model) {

		Cliente cliente = new Cliente();
		model.put("cliente", cliente);
		model.put("titulo", "Registrar nuevo cliente");
		return "formcliente";
	}

	@GetMapping(value = "/formcliente/{id}")
	public String editar(@PathVariable(value = "id") Long id, Map<String, Object> model) {
		Cliente cliente = null;
		if (id>0) {
			cliente = clienteService.findOne(id);
		}else {
			return "redirect:listcliente";
		}
		model.put("cliente", cliente);
		model.put("titulo", "Editar cliente");
		
		return "formcliente";
	}

	@PostMapping(value = "/formcliente")
	public String guardar(@Valid Cliente cliente, BindingResult result, Model model, SessionStatus status) {
		if (result.hasErrors()) {

			model.addAttribute("titulo", "Registrar nuevo cliente");
			return "formcliente";
		}

		clienteService.save(cliente);
		status.setComplete();
		return "redirect:listcliente";
	}
	
	@RequestMapping(value = "/eliminarcliente/{id}")
	public String eliminar(@PathVariable(value = "id") Long id) {
		if (id>0) {
			clienteService.delete(id);;
		}
		return "redirect:/listcliente";
	}
}
