package com.example.asados.controller;

import com.example.asados.dto.AsadoMesResumenDTO;
import com.example.asados.dto.AsadoRequestDTO;
import com.example.asados.dto.AsadoResponseDTO;
import com.example.asados.service.AsadoService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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
    public List<AsadoResponseDTO> listar(
            @RequestParam(required = false) String fechaDesde,
            @RequestParam(required = false) String fechaHasta
    ) {
        if (fechaDesde != null && fechaHasta != null) {
            return service.getByRangoFechas(
                    LocalDate.parse(fechaDesde),
                    LocalDate.parse(fechaHasta)
            );
        }
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

    @GetMapping("/mes")
    public List<AsadoResponseDTO> getAsadosPorMes(
            @RequestParam int anio,
            @RequestParam int mes
    ) {
        return service.getByMes(anio, mes);
    }

    @GetMapping("/mes/{mes}")
    public AsadoMesResumenDTO getResumenMes(
            @PathVariable int mes,
            @RequestParam int anio
    ) {
        return service.getResumenMes(anio, mes);
    }
}
