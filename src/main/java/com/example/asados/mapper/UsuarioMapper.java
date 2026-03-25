package com.example.asados.mapper;

import com.example.asados.dto.UsuarioResponseDTO;
import com.example.asados.entity.Usuario;

public class UsuarioMapper {

    public static UsuarioResponseDTO toDTO(Usuario usuario) {
        UsuarioResponseDTO dto = new UsuarioResponseDTO();
        dto.setId(usuario.getId());
        dto.setUsername(usuario.getUsername());
        return dto;
    }
}
