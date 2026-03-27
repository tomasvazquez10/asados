package com.example.asados.controller;

import com.example.asados.dto.CorteNombreRequestDTO;
import com.example.asados.dto.CorteNombreResponseDTO;
import com.example.asados.dto.CorteNombreStatsDTO;
import com.example.asados.service.CorteNombreService;
import com.example.asados.service.CorteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cortesNombre")
public class CorteNombreController {

    private final CorteNombreService service;
    private final CorteService corteService;

    public CorteNombreController(CorteNombreService service, CorteService corteService) {
        this.service = service;
        this.corteService = corteService;
    }

    @PostMapping
    public CorteNombreResponseDTO crear(@RequestBody CorteNombreRequestDTO dto) {
        return service.crear(dto);
    }

    @GetMapping
    public List<CorteNombreResponseDTO> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public CorteNombreResponseDTO obtener(@PathVariable Long id) {
        return service.obtener(id);
    }

    @PutMapping("/{id}")
    public CorteNombreResponseDTO actualizar(@PathVariable Long id,
                                      @RequestBody CorteNombreRequestDTO dto) {
        return service.actualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }

    @GetMapping("/stats")
    public List<CorteNombreStatsDTO> getStats() {
        return corteService.getStats();
    }

    @GetMapping("/stats/mes")
    public List<CorteNombreStatsDTO> getStatsByMes(
            @RequestParam int anio,
            @RequestParam int mes
    ) {
        return corteService.getStatsByMes(anio, mes);
    }
}
