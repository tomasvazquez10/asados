package com.example.asados.mapper;

import com.example.asados.dto.TipoAsadoResponseDTO;
import com.example.asados.entity.TipoAsado;

public class TipoAsadoMapper {

    public static TipoAsadoResponseDTO toDTO(TipoAsado t) {
        TipoAsadoResponseDTO dto = new TipoAsadoResponseDTO();
        dto.setId(t.getId());
        dto.setNombre(t.getNombre());
        dto.setDescripcion(t.getDescripcion());
        return dto;
    }
}
