package com.example.asados.service;

import com.example.asados.entity.RankingMensual;

import java.util.List;

public interface RankingMensualService {

    List<RankingMensual> generarSnapshot(Integer mes);
    List<RankingMensual> getAll();
    List<RankingMensual> getByMes(Integer mes);
    List<RankingMensual> getByComensalId(Long comensalId);
}
