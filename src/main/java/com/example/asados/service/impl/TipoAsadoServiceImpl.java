package com.example.asados.service.impl;

import com.example.asados.dto.TipoAsadoRequestDTO;
import com.example.asados.dto.TipoAsadoResponseDTO;
import com.example.asados.entity.TipoAsado;
import com.example.asados.mapper.TipoAsadoMapper;
import com.example.asados.repository.TipoAsadoRepository;
import com.example.asados.service.TipoAsadoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoAsadoServiceImpl implements TipoAsadoService {

    private final TipoAsadoRepository repo;

    public TipoAsadoServiceImpl(TipoAsadoRepository repo) {
        this.repo = repo;
    }

    public TipoAsadoResponseDTO crear(TipoAsadoRequestDTO dto) {
        TipoAsado t = new TipoAsado();
        t.setNombre(dto.getNombre());
        t.setDescripcion(dto.getDescripcion());
        return TipoAsadoMapper.toDTO(repo.save(t));
    }

    public List<TipoAsadoResponseDTO> listar() {
        return repo.findAll().stream()
                .map(TipoAsadoMapper::toDTO)
                .toList();
    }

    public TipoAsadoResponseDTO obtener(Long id) {
        TipoAsado t = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("No encontrado"));
        return TipoAsadoMapper.toDTO(t);
    }

    public TipoAsadoResponseDTO actualizar(Long id, TipoAsadoRequestDTO dto) {
        TipoAsado t = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("No encontrado"));

        t.setNombre(dto.getNombre());
        t.setDescripcion(dto.getDescripcion());

        return TipoAsadoMapper.toDTO(repo.save(t));
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}