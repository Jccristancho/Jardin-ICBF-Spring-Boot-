package com.example.Registro_Jardines.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class controladorAdmin {

    @GetMapping("/dashboardAdmin")
    public String showDashboard() {
        return "dashboardAdmin";
    }
}

