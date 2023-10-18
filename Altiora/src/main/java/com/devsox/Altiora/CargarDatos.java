package com.devsox.Altiora;

import com.devsox.Altiora.model.Articulo;
import com.devsox.Altiora.model.Cliente;
import com.devsox.Altiora.model.Orden;
import com.devsox.Altiora.repositorio.ArticuloRepository;
import com.devsox.Altiora.repositorio.ClienteRepository;
import com.devsox.Altiora.repositorio.OrdenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 Esta clase proporciona la funcion para cargar los datos de prueba y poder
 probar la funcionalidad del proyecto
 */
@Service
public class CargarDatos {
    @Autowired
    private ArticuloRepository articuloRepository;

    @Autowired
    private ClienteRepository usuarioRepository;

    @Autowired
    private OrdenRepository ordenRepository;

    public void cargarDatosDePrueba() {
        // Crea artículos de prueba
        Articulo articulo1 = new Articulo("A001", "CPU", new BigDecimal("800.00"));
        Articulo articulo2 = new Articulo("A002", "Monitor", new BigDecimal("300.00"));
        Articulo articulo3 = new Articulo("A003", "Teclado", new BigDecimal("20.00"));
        articuloRepository.save(articulo1);
        articuloRepository.save(articulo2);
        articuloRepository.save(articulo3);

        // Crea usuarios de prueba
        Cliente usuario1 = new Cliente( "Clave1", "Ada");
        Cliente usuario2 = new Cliente("Clave2", "Alan");
        Cliente usuario3 = new Cliente("Clave2", "Steve");
        Cliente usuario4 = new Cliente("Clave2", "Bill");
        usuarioRepository.save(usuario2);
        usuarioRepository.save(usuario3);
        usuarioRepository.save(usuario4);

        // Crea una orden y añade productos a la orden
        Orden orden = new Orden("O001", new Date(), usuario1);
        orden.getArticulos().add(articulo1);
        orden.getArticulos().add(articulo2);

        List<Orden> ordenes = new ArrayList<>();
        ordenes.add(orden);

        //Asigna la orden al usuario 1
        usuario1.setOrdenes(ordenes);
        usuarioRepository.save(usuario1);
        ordenRepository.save(orden);
    }
}
