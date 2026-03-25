package com.example.asados.controller;

import com.example.asados.dto.TipoAsadoRequestDTO;
import com.example.asados.dto.TipoAsadoResponseDTO;
import com.example.asados.service.TipoAsadoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipo-asados")
public class TipoAsadoController {

    private final TipoAsadoService service;

    public TipoAsadoController(TipoAsadoService service) {
        this.service = service;
    }

    @PostMapping
    public TipoAsadoResponseDTO crear(@RequestBody TipoAsadoRequestDTO dto) {
        return service.crear(dto);
    }

    @GetMapping
    public List<TipoAsadoResponseDTO> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public TipoAsadoResponseDTO obtener(@PathVariable Long id) {
        return service.obtener(id);
    }

    @PutMapping("/{id}")
    public TipoAsadoResponseDTO actualizar(@PathVariable Long id,
                                           @RequestBody TipoAsadoRequestDTO dto) {
        return service.actualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}