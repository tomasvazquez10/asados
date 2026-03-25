package com.example.asados.controller;

import com.example.asados.dto.GrupoRequestDTO;
import com.example.asados.dto.GrupoResponseDTO;
import com.example.asados.service.GrupoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grupos")
public class GrupoController {

    private final GrupoService service;

    public GrupoController(GrupoService service) {
        this.service = service;
    }

    @PostMapping
    public GrupoResponseDTO crear(@RequestBody GrupoRequestDTO dto) {
        return service.crear(dto);
    }

    @GetMapping
    public List<GrupoResponseDTO> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public GrupoResponseDTO obtener(@PathVariable Long id) {
        return service.obtener(id);
    }

    @PutMapping("/{id}")
    public GrupoResponseDTO actualizar(@PathVariable Long id,
                                      @RequestBody GrupoRequestDTO dto) {
        return service.actualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
