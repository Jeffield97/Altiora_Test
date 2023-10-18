package com.devsox.Altiora.controller;

import com.devsox.Altiora.CargarDatos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CargaDatosController {
    @Autowired
    private CargarDatos datosPruebaService;

    @GetMapping("/cargar-datos-de-prueba")
    public String cargarDatosDePrueba() {
        datosPruebaService.cargarDatosDePrueba();
        return "redirect:/"; // Redirige a la página principal u otra página adecuada
    }
}
