package com.example.Registro_Jardines.controler;


import com.example.Registro_Jardines.interfaceService.EvaluacionService;
import com.example.Registro_Jardines.interfaceService.IinventarioServiceRegistrosNinos;
import com.example.Registro_Jardines.modelo.Evaluacion;
import com.example.Registro_Jardines.modelo.registrosNinos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@Controller
@RequestMapping("/evaluacion")
public class EvaluacionController {

    private final EvaluacionService evaluacionService;
    private final IinventarioServiceRegistrosNinos inventarioServiceRegistrosNinos;

    @Autowired
    public EvaluacionController(EvaluacionService evaluacionService, IinventarioServiceRegistrosNinos registrosNinosService) {
        this.evaluacionService = evaluacionService;
        this.inventarioServiceRegistrosNinos = registrosNinosService;
    }

    @GetMapping("/formulario/{registroId}")
    public String mostrarFormularioEvaluacion(@PathVariable int registroId, Model model) {
        Optional<registrosNinos> ninoOptional = inventarioServiceRegistrosNinos.listar_ninosId(registroId);

        if (ninoOptional.isPresent()) {
            registrosNinos nino = ninoOptional.get();
            model.addAttribute("ninoId", nino.getRegistro());
            model.addAttribute("nino", nino);
            model.addAttribute("evaluacion", new Evaluacion());
            return "evaluacionNino";
        } else {
            // Manejar el caso en que el niño no existe (puedes redirigir o mostrar un mensaje de error)
            return "error"; // o redirigir a una página de error
        }
    }


    @PostMapping("/guardar")
    public String guardarEvaluacion(@ModelAttribute Evaluacion evaluacion) {

        evaluacionService.guardarEvaluacion(evaluacion);

        return "redirect:/registrar_ninos";
    }
}
