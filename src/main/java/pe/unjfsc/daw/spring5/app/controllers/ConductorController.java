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

import pe.unjfsc.daw.spring5.app.models.entity.Conductor;
import pe.unjfsc.daw.spring5.app.models.service.IConductorService;

@Controller
@SessionAttributes("conductor")
public class ConductorController {

	@Autowired
	private IConductorService conductorService;
	
	@GetMapping(value = "/listconductor")
	public String listar(Model model) {
		
		model.addAttribute("titulo", "Listado de conductores");
		model.addAttribute("conductores", conductorService.findAll());
		return "listconductor";
	}
	
	@GetMapping(value = "/formconductor")
	public String crear(Map<String, Object> model) {
		
		Conductor conductor = new Conductor();
		model.put("conductor", conductor);
		model.put("titulo", "Resgistrar nuevo conductor");
		return "formconductor";
	}
	
	@GetMapping(value = "/formconductor/{id}")
	public String editar(@PathVariable(value = "id") Long id, Map<String, Object> model) {
		Conductor conductor = null;
		if (id>0) {
			conductor = conductorService.findOne(id);
		}else {
			return "redirect:listconductor";
		}
		model.put("conductor", conductor);
		model.put("titulo", "Editar conductor");
		
		return "formconductor";
	}
	
	@PostMapping(value = "/formconductor")
	public String guardar(@Valid Conductor conductor, BindingResult result, Model model, SessionStatus status) {
		if (result.hasErrors()) {

			model.addAttribute("titulo", "Registrar nuevo conductor");
			return "formconductor";
		}

		conductorService.save(conductor);
		status.setComplete();
		return "redirect:listconductor";
	}
	
	@RequestMapping(value = "/eliminarconductor/{id}")
	public String eliminar(@PathVariable(value = "id") Long id) {
		if (id>0) {
			conductorService.delete(id);;
		}
		return "redirect:/listconductor";
	}
}
