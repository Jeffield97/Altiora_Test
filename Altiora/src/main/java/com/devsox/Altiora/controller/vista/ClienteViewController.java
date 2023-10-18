package com.devsox.Altiora.controller.vista;

import com.devsox.Altiora.model.Cliente;
import com.devsox.Altiora.repositorio.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ClienteViewController {
    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/clientes/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        System.out.println("Accediendo a CLIENTES NUEVO");
        model.addAttribute("cliente", new Cliente());
        return "Cliente/formulario";
    }

    @GetMapping("/clientes/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        Cliente cliente = clienteRepository.findById(id).orElse(null);
        if (cliente == null) {
            return "redirect:/clientes";
        }
        model.addAttribute("cliente", cliente);
        return "Cliente/formulario";
    }

    @GetMapping("/clientes")
    public String listarClientes(Model model) {
        model.addAttribute("clientes", clienteRepository.findAll());
        return "Cliente/lista";
    }
}
