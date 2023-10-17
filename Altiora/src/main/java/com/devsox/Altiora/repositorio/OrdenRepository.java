package com.devsox.Altiora.repositorio;

import com.devsox.Altiora.model.Orden;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdenRepository extends JpaRepository<Orden, String> {
}
