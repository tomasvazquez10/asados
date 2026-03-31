package com.example.asados.repository;

import com.example.asados.entity.CorteNombre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CorteNombreRepository extends JpaRepository<CorteNombre, Long> {

    Optional<CorteNombre> findByNombreIgnoreCase(String nombre);
}
