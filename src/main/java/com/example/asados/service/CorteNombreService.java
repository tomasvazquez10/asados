package com.example.asados.service;

import com.example.asados.dto.CorteNombreRequestDTO;
import com.example.asados.dto.CorteNombreResponseDTO;

import java.util.List;

public interface CorteNombreService {
    CorteNombreResponseDTO crear(CorteNombreRequestDTO dto);
    List<CorteNombreResponseDTO> listar();
    CorteNombreResponseDTO obtener(Long id);
    CorteNombreResponseDTO actualizar(Long id, CorteNombreRequestDTO dto);
    void eliminar(Long id);
}
