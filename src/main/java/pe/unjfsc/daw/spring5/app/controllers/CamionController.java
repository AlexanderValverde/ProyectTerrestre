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

import pe.unjfsc.daw.spring5.app.models.entity.Camion;
import pe.unjfsc.daw.spring5.app.models.service.ICamionService;


@Controller
@SessionAttributes("camion")
public class CamionController {

	@Autowired
	private ICamionService camionService;
	
	@GetMapping(value = "/listcamion")
	public String listar(Model model) {

		model.addAttribute("titulo", "Listado de camiones");
		model.addAttribute("camiones", camionService.findAll());
		return "listcamion";
	}

	@GetMapping(value = "/formcamion")
	public String crear(Map<String, Object> model) {

		Camion camion = new Camion();
		model.put("camion", camion);
		model.put("titulo", "Registrar nuevo camion");
		return "formcamion";
	}

	@GetMapping(value = "/formcamion/{id}")
	public String editar(@PathVariable(value = "id") Long id, Map<String, Object> model) {
		Camion camion = null;
		if (id>0) {
			camion = camionService.findOne(id);
		}else {
			return "redirect:listcamion";
		}
		model.put("camion", camion);
		model.put("titulo", "Editar camion");
		
		return "formcamion";
	}

	@PostMapping(value = "/formcamion")
	public String guardar(@Valid Camion camion, BindingResult result, Model model, SessionStatus status) {
		if (result.hasErrors()) {

			model.addAttribute("titulo", "Registrar nuevo camion");
			return "formcamion";
		}

		camionService.save(camion);
		status.setComplete();
		return "redirect:listcamion";
	}
	
	@RequestMapping(value = "/eliminarcamion/{id}")
	public String eliminar(@PathVariable(value = "id") Long id) {
		if (id>0) {
			camionService.delete(id);;
		}
		return "redirect:/listcamion";
	}
}
