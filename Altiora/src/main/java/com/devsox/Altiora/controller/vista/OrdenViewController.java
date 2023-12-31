package com.devsox.Altiora.controller.vista;

import com.devsox.Altiora.repositorio.OrdenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
/**
 * Se declaran las rutas a las que se puede acceder y
 * las plantillas que se retornan en cada una
 * */
public class OrdenViewController {
    @Autowired
    private OrdenRepository ordenRepository;

    @GetMapping("/ordenes")
    public String listarOrdenes(Model model){
        model.addAttribute("ordenes",ordenRepository.findAll());
        return  "Orden/lista";
    }
}
