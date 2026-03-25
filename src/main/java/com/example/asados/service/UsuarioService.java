package com.example.asados.service;

import com.example.asados.dto.UsuarioRequestDTO;
import com.example.asados.dto.UsuarioResponseDTO;

import java.util.List;

public interface UsuarioService {

    UsuarioResponseDTO crear(UsuarioRequestDTO dto);

    List<UsuarioResponseDTO> listar();

    UsuarioResponseDTO obtenerPorId(Long id);

    UsuarioResponseDTO actualizar(Long id, UsuarioRequestDTO dto);

    void eliminar(Long id);
}