package com.example.asados.mapper;

import com.example.asados.dto.CorteNombreResponseDTO;
import com.example.asados.entity.CorteNombre;

public class CorteNombreMapper {

    public static CorteNombreResponseDTO toDTO(CorteNombre t) {
        CorteNombreResponseDTO dto = new CorteNombreResponseDTO();
        dto.setId(t.getId());
        dto.setNombre(t.getNombre());
        dto.setTipo(t.getTipo());
        return dto;
    }
}
