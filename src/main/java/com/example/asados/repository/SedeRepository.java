package com.example.asados.repository;

import com.example.asados.entity.Sede;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SedeRepository extends JpaRepository<Sede, Long> {

    Optional<Sede> findByNombreIgnoreCase(String nombre);

}