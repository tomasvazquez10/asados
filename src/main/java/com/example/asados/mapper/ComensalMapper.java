package com.example.asados.mapper;

import com.example.asados.dto.ComensalResponseDTO;
import com.example.asados.entity.Comensal;

public class ComensalMapper {

    public static ComensalResponseDTO toDTO(Comensal c) {
        ComensalResponseDTO dto = new ComensalResponseDTO();
        dto.setId(c.getId());
        dto.setUsuario(c.getUsuario());
        dto.setNombre(c.getNombre());
        dto.setGrupoId(c.getGrupo().getId());
        dto.setGrupoNombre(c.getGrupo().getNombre());
        return dto;
    }
}
