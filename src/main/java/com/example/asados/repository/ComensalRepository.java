package com.example.asados.repository;

import com.example.asados.entity.Comensal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface ComensalRepository extends JpaRepository<Comensal, Long> {

    @Query("""
        SELECT c.nombre, COUNT(a)
        FROM Asado a
        JOIN a.comensales c
        GROUP BY c.nombre
    """)
    List<Object[]> getStatsRaw();

    // 📊 Por mes
    @Query("""
        SELECT c.nombre, COUNT(a)
        FROM Asado a
        JOIN a.comensales c
        WHERE a.fecha BETWEEN :desde AND :hasta
        GROUP BY c.nombre
    """)
    List<Object[]> getStatsByFechaRaw(
            LocalDate desde,
            LocalDate hasta
    );
}
