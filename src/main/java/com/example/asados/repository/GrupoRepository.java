package com.example.asados.repository;

import com.example.asados.entity.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GrupoRepository extends JpaRepository<Grupo, Long> {
    Optional<Grupo> findByNombreIgnoreCase(String nombre);

}
