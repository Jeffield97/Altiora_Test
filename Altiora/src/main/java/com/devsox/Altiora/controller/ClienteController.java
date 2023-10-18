package com.devsox.Altiora.controller;

import com.devsox.Altiora.model.Cliente;
import com.devsox.Altiora.repositorio.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteRepository clienteRepository;



    @PostMapping("/nuevo")
    public String guardarCliente(@ModelAttribute("cliente") Cliente cliente) {
        System.out.println("Creando cliente,,,,");
        clienteRepository.save(cliente);
        return "redirect:/clientes";
    }

    @PutMapping("/{id}/editar")
    public String actualizarCliente(@PathVariable Long id, @ModelAttribute("cliente") Cliente cliente) {
        clienteRepository.save(cliente);
        return "redirect:/clientes";
    }

    @GetMapping("/clientes/eliminar")
    public String eliminarCliente(@RequestParam("id") Long clienteId) {
        System.out.println("Eliminandooooooooo!!!");
        // Lógica para eliminar el cliente por su ID
        clienteRepository.deleteById(clienteId); // Suponiendo que tienes un repositorio de clientes
        return "redirect:/clientes"; // Redirige a la lista de clientes actualizada
    }
}
