package com.example.asados.mapper;

import com.example.asados.dto.GrupoResponseDTO;
import com.example.asados.entity.Grupo;

public class GrupoMapper {

    public static GrupoResponseDTO toDTO(Grupo t) {
        GrupoResponseDTO dto = new GrupoResponseDTO();
        dto.setId(t.getId());
        dto.setNombre(t.getNombre());
        dto.setDescripcion(t.getDescripcion());
        return dto;
    }
}
