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
import java.util.Date;

@Service
public class CargarDatos {
    @Autowired
    private ArticuloRepository articuloRepository;

    @Autowired
    private ClienteRepository usuarioRepository;

    @Autowired
    private OrdenRepository ordenRepository;

    public void cargarDatosDePrueba() {
        // Crear artículos de prueba
        Articulo articulo1 = new Articulo("A001", "Artículo 1", new BigDecimal("10.00"));
        Articulo articulo2 = new Articulo("A002", "Artículo 2", new BigDecimal("20.00"));
        articuloRepository.save(articulo1);
        articuloRepository.save(articulo2);

        // Crear usuarios de prueba
        Cliente usuario1 = new Cliente( "Clave1", "Usuario 1");
        Cliente usuario2 = new Cliente("Clave2", "Usuario 2");
        usuarioRepository.save(usuario1);
        usuarioRepository.save(usuario2);

        // Crear una orden de prueba con artículos y usuario
        Orden orden = new Orden("O001", new Date(), usuario1);
        orden.getArticulos().add(articulo1);
        orden.getArticulos().add(articulo2);
        ordenRepository.save(orden);
    }
}
