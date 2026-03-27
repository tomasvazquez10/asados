package com.example.asados.service;

import com.example.asados.dto.CorteNombreStatsDTO;
import com.example.asados.dto.CorteRequestDTO;
import com.example.asados.dto.CorteResponseDTO;

import java.util.List;

public interface CorteService {
    CorteResponseDTO crear(CorteRequestDTO dto);
    List<CorteResponseDTO> listar();
    CorteResponseDTO obtener(Long id);
    CorteResponseDTO actualizar(Long id, CorteRequestDTO dto);
    void eliminar(Long id);

    List<CorteNombreStatsDTO> getStats();
    List<CorteNombreStatsDTO> getStatsByMes(int anio, int mes);

}
