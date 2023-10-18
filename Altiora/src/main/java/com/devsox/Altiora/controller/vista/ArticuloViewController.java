package com.devsox.Altiora.controller.vista;

import com.devsox.Altiora.repositorio.ArticuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ArticuloViewController {
    @Autowired
    private ArticuloRepository articuloRepository;

    @GetMapping("/articulos")
    public String listarArticulos(Model model)
    {
        model.addAttribute("articulos",articuloRepository.findAll());
        return "Articulo/lista";
    }
}
