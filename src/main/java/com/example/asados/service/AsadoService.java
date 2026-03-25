package com.example.asados.service;

import com.example.asados.dto.AsadoRequestDTO;
import com.example.asados.dto.AsadoResponseDTO;

import java.util.List;

public interface AsadoService {

    AsadoResponseDTO crear(AsadoRequestDTO dto);

    List<AsadoResponseDTO> listar();

    AsadoResponseDTO obtener(Long id);

    void eliminar(Long id);
}


