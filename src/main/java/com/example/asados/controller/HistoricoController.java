package com.example.asados.controller;

import com.example.asados.entity.Historico;
import com.example.asados.service.HistoricoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/historicos")
public class HistoricoController {

    private final HistoricoService service;

    public HistoricoController(HistoricoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Historico> crear(@RequestBody Historico historico) {
        return ResponseEntity.ok(service.crear(historico));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Historico> actualizar(@PathVariable Long id,
                                                @RequestBody Historico historico) {
        return ResponseEntity.ok(service.actualizar(id, historico));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Historico> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.obtenerPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<Historico>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/buscar")
    public ResponseEntity<Historico> obtenerPorMesYAnio(
            @RequestParam Integer mes,
            @RequestParam Integer anio) {

        return service.obtenerPorMesYAnio(mes, anio)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
