package com.example.asados.service.impl;

import com.example.asados.dto.*;
import com.example.asados.entity.CorteNombre;
import com.example.asados.mapper.CorteNombreMapper;
import com.example.asados.repository.CorteNombreRepository;
import com.example.asados.service.CorteNombreService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CorteNombreServiceImpl implements CorteNombreService {

    private final CorteNombreRepository repo;

    public CorteNombreServiceImpl(CorteNombreRepository repo) {
        this.repo = repo;
    }

    @Override
    public CorteNombreResponseDTO crear(CorteNombreRequestDTO dto) {
        CorteNombre t = new CorteNombre();
        t.setNombre(dto.getNombre());
        t.setTipo(dto.getTipo());
        return CorteNombreMapper.toDTO(repo.save(t));
    }

    @Override
    public List<CorteNombreResponseDTO> listar() {
        return repo.findAll().stream()
                .map(CorteNombreMapper::toDTO)
                .toList();
    }

    @Override
    public CorteNombreResponseDTO obtener(Long id) {
        CorteNombre t = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("No encontrado"));
        return CorteNombreMapper.toDTO(t);
    }

    @Override
    public CorteNombreResponseDTO actualizar(Long id, CorteNombreRequestDTO dto) {
        CorteNombre t = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("No encontrado"));

        t.setNombre(dto.getNombre());
        t.setTipo(dto.getTipo());

        return CorteNombreMapper.toDTO(repo.save(t));
    }

    @Override
    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}
