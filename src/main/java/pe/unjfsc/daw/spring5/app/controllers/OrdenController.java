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

import pe.unjfsc.daw.spring5.app.models.entity.Orden;
import pe.unjfsc.daw.spring5.app.models.service.IOrdenService;
//import pe.unjfsc.daw.spring5.app.models.entity.Ruta;
//import pe.unjfsc.daw.spring5.app.models.service.IRutaService;
//import pe.unjfsc.daw.spring5.app.models.entity.Camion;
//import pe.unjfsc.daw.spring5.app.models.entity.Cliente;
//import pe.unjfsc.daw.spring5.app.models.entity.Conductor;
//import pe.unjfsc.daw.spring5.app.models.entity.Ruta;


@Controller
@SessionAttributes("orden")
public class OrdenController {

	@Autowired
	private IOrdenService ordenService;

	@GetMapping(value = "/listorden")
	public String listar(Model model) {

		model.addAttribute("titulo", "Listado de las ordenes de carga");
		model.addAttribute("ordenes", ordenService.findAll());
		return "listorden";
	}


	@GetMapping(value = "/formorden")
	public String crear(Map<String, Object> model) {

		Orden orden = new Orden();
		model.put("orden", orden);
//		Ruta ruta = new Ruta();
//		model.put("ruta", ruta);
//		Cliente cliente = new Cliente();
//		model.put("cliente", cliente);
//		Camion camion = new Camion();
//		model.put("camion", camion);
//		Conductor conductor = new Conductor();
//		model.put("conductor", conductor);
		model.put("titulo", "Registrar nueva orden");
		model.put("rutas", ordenService.findAllRuta());
		model.put("clientes", ordenService.findAllCliente());
		model.put("camiones", ordenService.findAllCamion());
		model.put("conductores", ordenService.findAllConductor());
		return "formorden";
	}

	@GetMapping(value = "/formordenedit/{id}")
	public String editar(@PathVariable(value = "id") Long id, Map<String, Object> model) {
		Orden orden = null;
		if (id>0) {
			orden = ordenService.findOne(id);

		}else {
			return "redirect:listorden";
		}
		model.put("orden", orden);
		model.put("titulo", "Editar orden");
		
		return "formordenedit";
	}

	@PostMapping(value = "/formorden")
	public String guardar(@Valid Orden orden, BindingResult result, Model model, SessionStatus status) {
		if (result.hasErrors()) {

			model.addAttribute("titulo", "Registrar nueva orden");
			return "formorden";
		}

		ordenService.save(orden);
		status.setComplete();
		return "redirect:listorden";
	}
	
	@RequestMapping(value = "/eliminarorden/{id}")
	public String eliminar(@PathVariable(value = "id") Long id) {
		if (id>0) {
			ordenService.delete(id);;
		}
		return "redirect:/listorden";
	}
}
