package com.devsox.Altiora.repositorio;

import com.devsox.Altiora.model.Orden;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrdenRepository extends JpaRepository<Orden, String> {
    //Se declara esta funcion personalizada para ser utilizada en los controladores
    Orden findByCodigo(String codigo);
}
