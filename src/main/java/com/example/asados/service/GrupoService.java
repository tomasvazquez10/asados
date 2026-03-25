package com.example.asados.service;

import com.example.asados.dto.GrupoRequestDTO;
import com.example.asados.dto.GrupoResponseDTO;

import java.util.List;

public interface GrupoService {
    GrupoResponseDTO crear(GrupoRequestDTO dto);
    List<GrupoResponseDTO> listar();
    GrupoResponseDTO obtener(Long id);
    GrupoResponseDTO actualizar(Long id, GrupoRequestDTO dto);
    void eliminar(Long id);
}
