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


import pe.unjfsc.daw.spring5.app.models.entity.Ruta;
import pe.unjfsc.daw.spring5.app.models.service.IRutaService;

@Controller
@SessionAttributes("ruta")
public class RutaController {

	@Autowired
	private IRutaService rutaService;
	
	@GetMapping(value = "/listruta")
	public String listar(Model model) {
		
		model.addAttribute("titulo", "Listado de rutas");
		model.addAttribute("rutas", rutaService.findAll());
		return "listruta";
	}
	@GetMapping(value = "/formruta")
	public String crear(Map<String, Object> model) {

		Ruta ruta = new Ruta();
		model.put("ruta", ruta);
		model.put("titulo", "Registrar nueva ruta");
		return "formruta";
	}

	@GetMapping(value = "/formruta/{id}")
	public String editar(@PathVariable(value = "id") Long id, Map<String, Object> model) {
		Ruta ruta = null;
		if (id>0) {
			ruta = rutaService.findOne(id);
		}else {
			return "redirect:listruta";
		}
		model.put("ruta", ruta);
		model.put("titulo", "Editar ruta");
		
		return "formruta";
	}

	@PostMapping(value = "/formruta")
	public String guardar(@Valid Ruta ruta, BindingResult result, Model model, SessionStatus status) {
		if (result.hasErrors()) {

			model.addAttribute("titulo", "Registrar nueva ruta");
			return "formruta";
		}

		rutaService.save(ruta);
		status.setComplete();
		return "redirect:listruta";
	}
	
	@RequestMapping(value = "/eliminarruta/{id}")
	public String eliminar(@PathVariable(value = "id") Long id) {
		if (id>0) {
			rutaService.delete(id);;
		}
		return "redirect:/listruta";
	}
}
