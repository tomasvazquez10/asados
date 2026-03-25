package com.example.asados.service;

import com.example.asados.dto.TipoAsadoRequestDTO;
import com.example.asados.dto.TipoAsadoResponseDTO;

import java.util.List;

public interface TipoAsadoService {
    TipoAsadoResponseDTO crear(TipoAsadoRequestDTO dto);
    List<TipoAsadoResponseDTO> listar();
    TipoAsadoResponseDTO obtener(Long id);
    TipoAsadoResponseDTO actualizar(Long id, TipoAsadoRequestDTO dto);
    void eliminar(Long id);
}