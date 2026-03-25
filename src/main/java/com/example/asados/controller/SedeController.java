package com.example.asados.controller;

import com.example.asados.dto.SedeRequestDTO;
import com.example.asados.dto.SedeResponseDTO;
import com.example.asados.service.SedeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sedes")
public class SedeController {

    private final SedeService service;

    public SedeController(SedeService service) {
        this.service = service;
    }

    @PostMapping
    public SedeResponseDTO crear(@RequestBody SedeRequestDTO dto) {
        return service.crear(dto);
    }

    @GetMapping
    public List<SedeResponseDTO> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public SedeResponseDTO obtener(@PathVariable Long id) {
        return service.obtener(id);
    }

    @PutMapping("/{id}")
    public SedeResponseDTO actualizar(@PathVariable Long id,
                                           @RequestBody SedeRequestDTO dto) {
        return service.actualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}