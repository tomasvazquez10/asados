package com.example.asados.controller;

import com.example.asados.dto.AsadoRequestDTO;
import com.example.asados.dto.AsadoResponseDTO;
import com.example.asados.service.AsadoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/asados")
public class AsadoController {

    private final AsadoService service;

    public AsadoController(AsadoService service) {
        this.service = service;
    }

    @PostMapping
    public AsadoResponseDTO crear(@RequestBody AsadoRequestDTO dto) {
        return service.crear(dto);
    }

    @GetMapping
    public List<AsadoResponseDTO> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public AsadoResponseDTO obtener(@PathVariable Long id) {
        return service.obtener(id);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
