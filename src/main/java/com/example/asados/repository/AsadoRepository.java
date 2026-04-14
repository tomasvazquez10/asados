package com.example.asados.repository;

import com.example.asados.dto.SedeStatsDTO;
import com.example.asados.entity.Asado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface AsadoRepository extends JpaRepository<Asado, Long>{

    List<Asado> findByFechaBetween(LocalDate fechaDesde, LocalDate fechaHasta);

    @Query("""
        SELECT new com.example.asados.dto.SedeStatsDTO(
            a.sede.nombre,
            COUNT(a)
        )
        FROM Asado a
        GROUP BY a.sede.nombre
        ORDER BY COUNT(a) DESC
    """)
    List<SedeStatsDTO> getStatsPorSede();

    @Query("""
        SELECT new com.example.asados.dto.SedeStatsDTO(
            a.sede.nombre,
            COUNT(a)
        )
        FROM Asado a
        WHERE a.fecha BETWEEN :desde AND :hasta
        GROUP BY a.sede.nombre
        ORDER BY COUNT(a) DESC
    """)
    List<SedeStatsDTO> getStatsPorSedeByFecha(
            LocalDate desde,
            LocalDate hasta
    );

    @Query("SELECT COUNT(a) FROM Asado a WHERE MONTH(a.fecha) = :mes AND YEAR(a.fecha) = :anio")
    int countByMes(@Param("mes") int mes, @Param("anio") int anio);

    @Query("SELECT COUNT(a) FROM Asado a")
    int countTotal();

    @Query("""
    SELECT a FROM Asado a
    JOIN a.comensales c
    WHERE c.id = :comensalId
    """)
    List<Asado> findByComensalId(@Param("comensalId") Long comensalId);
}
