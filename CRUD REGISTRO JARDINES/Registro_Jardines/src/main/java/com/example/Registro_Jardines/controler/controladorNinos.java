package com.example.Registro_Jardines.controler;

import java.util.List;
import java.util.Optional;

import com.example.Registro_Jardines.interfaceService.IinventarioServiceRegistrosNinos;
import com.example.Registro_Jardines.interfaceService.IinventarioServiceRegistrosJardines;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.Registro_Jardines.modelo.*;

@Controller
@RequestMapping
public class controladorNinos {

	@Autowired
	private IinventarioServiceRegistrosJardines registrosJardinesService;

	@Autowired
	private IinventarioServiceRegistrosNinos registrosNinosService;


	@GetMapping("/registrar_ninos")
	public String registrar_ninos(Model model) {
		List<registrosNinos> registrosNinos = registrosNinosService.listar_ninos();
		model.addAttribute("registrosNinos", registrosNinos);
		return "indexNinos";
	}
	@GetMapping("/newN")
	public String agregarNino(Model model) {
		model.addAttribute("registrosNinos", new registrosNinos());
		List<registrosJardines> listaJardines = registrosJardinesService.listar_registros();
		model.addAttribute("listaJardines", listaJardines);
		return "formNinos";
	}


	@PostMapping("/saveN")
	public String guardarRegistroNino(@Valid registrosNinos registroNino) {
		if (registroNino.getRegistro() > 0) {
			// Es una edición
			registrosNinosService.editarN(registroNino);
		} else {
			// Es un nuevo registro
			registrosNinosService.saveN(registroNino);
		}
		return "redirect:/registrar_ninos";
	}



	@GetMapping("/editarN/{id}")
	public String editar(@PathVariable int id, Model model) {
		Optional<registrosNinos> registro = registrosNinosService.listar_ninosId(id);

		// Verifica si el registro existe antes de agregarlo al modelo
		if (registro.isPresent()) {
			model.addAttribute("registro", registro.get());
		}

		List<registrosJardines> listaJardines = registrosJardinesService.listar_registros();
		model.addAttribute("listaJardines", listaJardines);

		return "formNinos";
	}
	@GetMapping("/eliminarN/{id}")
	public String delete(Model model, @PathVariable int id) {
	    registrosNinosService.deleteN(id);
	    return "redirect:/registrar_ninos";
	}
}

