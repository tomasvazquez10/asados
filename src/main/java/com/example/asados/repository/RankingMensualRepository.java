package com.example.asados.repository;

import com.example.asados.entity.Asado;
import com.example.asados.entity.RankingMensual;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface RankingMensualRepository extends JpaRepository<RankingMensual, Long> {

    @Query("""
    SELECT r FROM RankingMensual r
    JOIN r.comensal c
    WHERE c.id = :comensalId
    """)
    List<RankingMensual> findByComensalId(@Param("comensalId") Long comensalId);

    boolean existsByAnioAndMes(Integer anio, Integer mes);
    Optional<RankingMensual> findByComensalIdAndAnioAndMes(Long comensalId, Integer anio, Integer mes);
    List<RankingMensual> findByMesOrderByRankingAsc(Integer mes);
    List<RankingMensual> findByComensalIdOrderByAnioAscMesAsc(Long comensalId);

}
