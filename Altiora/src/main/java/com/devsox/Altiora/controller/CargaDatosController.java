package com.devsox.Altiora.controller;

import com.devsox.Altiora.CargarDatos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
/**
 * Este controlador se utiliza para cargar los datos al momento de acceder a /cargar-datos
 * de este modo se puede visualizar el funcionamiento del proyecto.
 **/
public class CargaDatosController {
    @Autowired
    private CargarDatos datosPruebaService;

    @GetMapping("/cargar-datos")
    public String cargarDatosDePrueba() {
        datosPruebaService.cargarDatosDePrueba();
        return "redirect:/clientes"; // Redirige a la página principal u otra página adecuada
    }
}
