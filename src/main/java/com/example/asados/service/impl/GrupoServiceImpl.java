package com.example.asados.service.impl;

import com.example.asados.dto.GrupoRequestDTO;
import com.example.asados.dto.GrupoResponseDTO;
import com.example.asados.entity.Grupo;
import com.example.asados.mapper.GrupoMapper;
import com.example.asados.repository.GrupoRepository;
import com.example.asados.service.GrupoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GrupoServiceImpl implements GrupoService {

    private final GrupoRepository repo;

    public GrupoServiceImpl(GrupoRepository repo) {
        this.repo = repo;
    }

    @Override
    public GrupoResponseDTO crear(GrupoRequestDTO dto) {
        Grupo t = new Grupo();
        t.setNombre(dto.getNombre());
        t.setDescripcion(dto.getDescripcion());
        return GrupoMapper.toDTO(repo.save(t));
    }

    public List<GrupoResponseDTO> listar() {
        return repo.findAll().stream()
                .map(GrupoMapper::toDTO)
                .toList();
    }

    public GrupoResponseDTO obtener(Long id) {
        Grupo t = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("No encontrado"));
        return GrupoMapper.toDTO(t);
    }

    public GrupoResponseDTO actualizar(Long id, GrupoRequestDTO dto) {
        Grupo t = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("No encontrado"));

        t.setNombre(dto.getNombre());
        t.setDescripcion(dto.getDescripcion());

        return GrupoMapper.toDTO(repo.save(t));
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}
