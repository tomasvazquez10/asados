package com.example.asados.mapper;

import com.example.asados.dto.SedeResponseDTO;
import com.example.asados.entity.Sede;

public class SedeMapper {

    public static SedeResponseDTO toDTO(Sede t) {
        SedeResponseDTO dto = new SedeResponseDTO();
        dto.setId(t.getId());
        dto.setNombre(t.getNombre());
        dto.setDescripcion(t.getDescripcion());
        return dto;
    }
}
