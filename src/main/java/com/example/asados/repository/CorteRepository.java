package com.example.asados.repository;

import com.example.asados.dto.CorteNombreStatsDTO;
import com.example.asados.entity.Corte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface CorteRepository extends JpaRepository<Corte, Long> {

    @Query("""
        SELECT new com.example.asados.dto.CorteNombreStatsDTO(
            c.corteNombre.nombre,
            SUM(c.cantidad),
            COUNT(c)
        )
        FROM Corte c
        GROUP BY c.corteNombre.nombre
    """)
    List<CorteNombreStatsDTO> getStats();

    @Query("""
        SELECT new com.example.asados.dto.CorteNombreStatsDTO(
            c.corteNombre.nombre,
            SUM(c.cantidad),
            COUNT(c)
        )
        FROM Corte c
        WHERE c.asado.fecha BETWEEN :desde AND :hasta
        GROUP BY c.corteNombre.nombre
    """)
    List<CorteNombreStatsDTO> getStatsByFecha(
            LocalDate desde,
            LocalDate hasta
    );
}
