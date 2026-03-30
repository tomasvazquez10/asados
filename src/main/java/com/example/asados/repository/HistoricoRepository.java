package com.example.asados.repository;

import com.example.asados.entity.Historico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HistoricoRepository extends JpaRepository<Historico, Long> {

    Optional<Historico> findByMesAndAnio(Integer mes, Integer anio);

    List<Historico> findByAnio(Integer anio);
}
