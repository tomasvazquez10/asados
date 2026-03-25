package com.example.asados.mapper;

import com.example.asados.dto.CorteDTO;
import com.example.asados.dto.CorteResponseDTO;
import com.example.asados.entity.Corte;

public class CorteMapper {

    public static CorteResponseDTO toDTO(Corte t) {
        CorteResponseDTO dto = new CorteResponseDTO();
        dto.setId(t.getId());
        dto.setCantidad(t.getCantidad());
        dto.setCorteNombreDesc(t.getCorteNombre().getNombre());
        dto.setCorteNombreId(t.getCorteNombre().getId());
        dto.setAsadoId(t.getAsado().getId());
        return dto;
    }

    public static CorteDTO toCorteDTO(Corte t){
        CorteDTO dto = new CorteDTO();
        dto.setNombre(t.getCorteNombre().getNombre());
        dto.setCantidad(t.getCantidad());
        return dto;
    }
}
