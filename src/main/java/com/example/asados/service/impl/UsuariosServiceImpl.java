package com.example.asados.service.impl;

import com.example.asados.dto.UsuarioRequestDTO;
import com.example.asados.dto.UsuarioResponseDTO;
import com.example.asados.entity.Usuario;
import com.example.asados.mapper.UsuarioMapper;
import com.example.asados.repository.UsuarioRepository;
import com.example.asados.service.UsuarioService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuariosServiceImpl implements UsuarioService {

    private final UsuarioRepository repository;

    public UsuariosServiceImpl(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public UsuarioResponseDTO crear(UsuarioRequestDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setUsername(dto.getUsername());
        usuario.setPassword(dto.getPassword());

        return UsuarioMapper.toDTO(repository.save(usuario));
    }

    @Override
    public List<UsuarioResponseDTO> listar() {
        return repository.findAll()
                .stream()
                .map(UsuarioMapper::toDTO)
                .toList();
    }

    @Override
    public UsuarioResponseDTO obtenerPorId(Long id) {
        Usuario usuario = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        return UsuarioMapper.toDTO(usuario);
    }

    @Override
    public UsuarioResponseDTO actualizar(Long id, UsuarioRequestDTO dto) {
        Usuario usuario = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        usuario.setUsername(dto.getUsername());
        usuario.setPassword(dto.getPassword());

        return UsuarioMapper.toDTO(repository.save(usuario));
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}