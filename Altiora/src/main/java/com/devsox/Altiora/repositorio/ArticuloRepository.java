package com.devsox.Altiora.repositorio;

import com.devsox.Altiora.model.Articulo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticuloRepository extends JpaRepository<Articulo, String> {
    //Se declara esta funcion personalizada para ser utilizada en los controladores
    Articulo findByCodigo(String codigo);
}
