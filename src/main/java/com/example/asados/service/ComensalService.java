package com.example.asados.service;

import com.example.asados.dto.ComensalRequestDTO;
import com.example.asados.dto.ComensalResponseDTO;
import com.example.asados.dto.ComensalStatsDTO;

import java.util.List;

public interface ComensalService {

    ComensalResponseDTO crear(ComensalRequestDTO dto);

    List<ComensalResponseDTO> listar();

    ComensalResponseDTO obtener(Long id);

    ComensalResponseDTO actualizar(Long id, ComensalRequestDTO dto);

    void eliminar(Long id);

    List<ComensalStatsDTO> getStats();

    ComensalStatsDTO getStatsByComensalId(Long comensalId);

    List<ComensalStatsDTO> getStatsByMes(int anio, int mes);
}
