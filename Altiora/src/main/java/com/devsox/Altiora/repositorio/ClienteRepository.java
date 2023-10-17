package com.devsox.Altiora.repositorio;

import com.devsox.Altiora.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
