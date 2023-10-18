package com.devsox.Altiora.controller;

import com.devsox.Altiora.model.Articulo;
import com.devsox.Altiora.model.Cliente;
import com.devsox.Altiora.model.Orden;
import com.devsox.Altiora.repositorio.ArticuloRepository;
import com.devsox.Altiora.repositorio.ClienteRepository;
import com.devsox.Altiora.repositorio.OrdenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/clientes")
/**
 * Se definen las funciones CRUD para la clase Clientes
 **/
public class ClienteController {
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private OrdenRepository ordenRepository;

    @Autowired
    private ArticuloRepository articuloRepository;


    @PostMapping("/crear")
    public String crearCliente(@ModelAttribute Cliente cliente, @RequestParam("articulos") List<String> articulos, @RequestParam("fecha") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fecha, @RequestParam("codigo") String codigo) {
        // Guardar el cliente
        Cliente clienteGuardado = clienteRepository.save(cliente);

        if (clienteGuardado != null) {
            Orden orden = new Orden(codigo, fecha);
            orden.setCliente(clienteGuardado);


            //Agregar los articulos a la orden
            List<Articulo> articulosSeleccionados = articulos.stream().map(codigoArticulo -> articuloRepository.findByCodigo(codigoArticulo))
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
            System.out.println(articulosSeleccionados);
            orden.setArticulos(articulosSeleccionados);
            ordenRepository.save(orden);
        }
        return "redirect:/clientes";
    }

    @PostMapping("/nuevo")
    public String guardarCliente(@ModelAttribute("cliente") Cliente cliente) {
        clienteRepository.save(cliente);
        return "redirect:/clientes";
    }

    @PutMapping("/{id}/editar")
    public String actualizarCliente(@PathVariable Long id, @ModelAttribute("cliente") Cliente cliente) {
        clienteRepository.save(cliente);
        return "redirect:/clientes";
    }

    @PostMapping("/eliminar")
    public String eliminarCliente(@RequestParam("id") Long clienteId) {
        System.out.println("Eliminandooooooooo!!!");
        // Lógica para eliminar el cliente por su ID
        clienteRepository.deleteById(clienteId); // Suponiendo que tienes un repositorio de clientes
        return "redirect:/clientes"; // Redirige a la lista de clientes actualizada
    }
}
