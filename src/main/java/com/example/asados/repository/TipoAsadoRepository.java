package com.example.asados.repository;

import com.example.asados.entity.TipoAsado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TipoAsadoRepository extends JpaRepository<TipoAsado, Long> {

    Optional<TipoAsado> findByNombreIgnoreCase(String nombre);

}