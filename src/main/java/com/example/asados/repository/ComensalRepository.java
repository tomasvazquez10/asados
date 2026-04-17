package com.example.asados.repository;

import com.example.asados.entity.Comensal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ComensalRepository extends JpaRepository<Comensal, Long> {

    @Query("""
        SELECT c.nombre, COUNT(a), c.id
        FROM Asado a
        JOIN a.comensales c
        GROUP BY c.nombre, c.id
    """)
    List<Object[]> getStatsRaw();

    @Query("""
        SELECT c.nombre, COUNT(a), c.id
        FROM Asado a
        JOIN a.comensales c
        WHERE a.fecha BETWEEN :desde AND :hasta
        GROUP BY c.nombre, c.id
    """)
    List<Object[]> getStatsByFechaRaw(
            LocalDate desde,
            LocalDate hasta
    );

    Optional<Comensal> findByUsuarioIgnoreCase(String usuario);

    @Query("""
        SELECT c.nombre, COUNT(a), c.id
        FROM Asado a
        JOIN a.comensales c
        WHERE c.id = :comensalId
        GROUP BY c.nombre, c.id
    """)
    List<Object[]> getStatsRawByComensalId(Long comensalId);
}
