package com.example.asados.service;

import com.example.asados.dto.SedeRequestDTO;
import com.example.asados.dto.SedeResponseDTO;
import com.example.asados.dto.SedeStatsDTO;

import java.util.List;

public interface SedeService {
    SedeResponseDTO crear(SedeRequestDTO dto);
    List<SedeResponseDTO> listar();
    SedeResponseDTO obtener(Long id);
    SedeResponseDTO actualizar(Long id, SedeRequestDTO dto);
    void eliminar(Long id);

    List<SedeStatsDTO> getStats();
    List<SedeStatsDTO> getStatsByMes(int anio, int mes);
}
