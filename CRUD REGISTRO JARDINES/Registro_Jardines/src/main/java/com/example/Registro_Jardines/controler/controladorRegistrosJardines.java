package com.example.Registro_Jardines.controler;

import java.util.List;
import java.util.Optional;

import com.example.Registro_Jardines.modelo.registrosNinos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.Registro_Jardines.interfaceService.IinventarioServiceRegistrosJardines;
import com.example.Registro_Jardines.modelo.registrosJardines;

import jakarta.validation.Valid;

@Controller
@RequestMapping
public class controladorRegistrosJardines {
	
	@Autowired
	private IinventarioServiceRegistrosJardines service;


	@GetMapping("/listar_registros")
	public String listar_registros(Model model) {
		List<registrosJardines>registros=service.listar_registros();
		model.addAttribute("registros", registros);
		return "indexJardines";
	}
	@GetMapping("/new")
	public String agregar(Model model) {
		model.addAttribute("registros", new registrosJardines());
		return "formJardines";
	}
	@PostMapping("/save")
	public String save (@Valid registrosJardines p, Model model ) {
		service.save(p);
		return "redirect:/listar_registros";
		
	}
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable int id, Model model) {
		Optional<registrosJardines> registrosOptional = service.listar_registrosId(id);

		if (registrosOptional.isPresent()) {
			registrosJardines registros = registrosOptional.get();
			model.addAttribute("registros", registros);
			return "formJardines";
		} else {
			// Manejo del caso en que no se encuentra el registro
			// Puedes redirigir a una página de error o mostrar un mensaje adecuado
			return "redirect:/ruta-de-error";
		}
	}

	@PostMapping("/editar/{id}")
	public String editarPost(@PathVariable int id, @ModelAttribute("registro") registrosJardines registroActualizado) {
		Optional<registrosJardines> optionalRegistro = service.listar_registrosId(id);

		if (optionalRegistro.isPresent()) {
			registrosJardines registroExistente = optionalRegistro.get();

			registroExistente.setNombre(registroActualizado.getNombre());

			service.save(registroExistente);

			return "redirect:/listar_registros";
		} else {

			return "redirect:/ruta-de-error";
		}
	}
	@GetMapping("/eliminar/{id}")
	public String delete(Model model, @PathVariable int id) {
	    service.delete(id);
	    return "redirect:/listar_registros";
	}


}

