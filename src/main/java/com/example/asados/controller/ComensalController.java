package com.example.asados.controller;

import com.example.asados.dto.ComensalRequestDTO;
import com.example.asados.dto.ComensalResponseDTO;
import com.example.asados.service.ComensalService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comensales")
public class ComensalController {

    private final ComensalService service;

    public ComensalController(ComensalService service) {
        this.service = service;
    }

    @PostMapping
    public ComensalResponseDTO crear(@RequestBody ComensalRequestDTO dto) {
        return service.crear(dto);
    }

    @GetMapping
    public List<ComensalResponseDTO> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ComensalResponseDTO obtener(@PathVariable Long id) {
        return service.obtener(id);
    }

    @PutMapping("/{id}")
    public ComensalResponseDTO actualizar(@PathVariable Long id,
                                          @RequestBody ComensalRequestDTO dto) {
        return service.actualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}