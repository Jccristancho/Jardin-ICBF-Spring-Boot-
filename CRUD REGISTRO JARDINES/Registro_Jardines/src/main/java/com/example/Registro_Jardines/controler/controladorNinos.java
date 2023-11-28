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

			registrosNinosService.saveN(registroNino);

		return "redirect:/registrar_ninos";
	}



	@GetMapping("/editarN/{id}")
	public String editarGet(@PathVariable int id, Model model) {
		Optional<registrosNinos> optionalRegistro = registrosNinosService.listar_ninosId(id);

		if (optionalRegistro.isPresent()) {
			registrosNinos registro = optionalRegistro.get();
			System.out.println("Registro a editar: " + registro.toString()); // Verifica en la consola
			model.addAttribute("registro", registro);
		} else {

		}

		List<registrosJardines> listaJardines = registrosJardinesService.listar_registros();
		model.addAttribute("listaJardines", listaJardines);
		return "editFormNinos";
	}

	@PostMapping("/editarN/{id}")
	public String editarPost(@PathVariable int id, @ModelAttribute("registro") registrosNinos registroActualizado) {
		Optional<registrosNinos> optionalRegistro = registrosNinosService.listar_ninosId(id);

		if (optionalRegistro.isPresent()) {
			registrosNinos registroExistente = optionalRegistro.get();

			// Actualiza los campos necesarios con los valores del registroActualizado
			registroExistente.setNombre(registroActualizado.getNombre());
			// Actualiza otros campos según sea necesario

			// Guarda el registro actualizado en la base de datos
			registrosNinosService.saveN(registroExistente);

			// Redirige a la página que desees después de la actualización
			return "redirect:/registrar_ninos";
		} else {
			// Manejo del caso en que no se encuentra el registro
			// Puedes redirigir a una página de error o mostrar un mensaje adecuado
			return "redirect:/ruta-de-error";
		}
	}
	@GetMapping("/eliminarN/{id}")
	public String delete(Model model, @PathVariable int id) {
		registrosNinosService.deleteN(id);
		return "redirect:/registrar_ninos";
	}
	}

