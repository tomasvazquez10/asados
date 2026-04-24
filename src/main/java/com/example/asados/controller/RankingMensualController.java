package com.example.asados.controller;

import com.example.asados.entity.RankingMensual;
import com.example.asados.service.RankingMensualService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rankingMensual")
public class RankingMensualController {

    private final RankingMensualService service;

    public RankingMensualController(RankingMensualService service) {
        this.service = service;
    }

    @GetMapping
    public List<RankingMensual> getAll(){
        return service.getAll();
    }

    @GetMapping("/mes/{mes}")
    public List<RankingMensual> getByMes(@PathVariable Integer mes){
        return service.getByMes(mes);
    }

    @GetMapping("/comensal/{comensalId}")
    public List<RankingMensual> getByComensal(@PathVariable Long comensalId){
        return service.getByComensalId(comensalId);
    }

    @PostMapping("/snapshot/{mes}")
    public ResponseEntity<List<RankingMensual>> snapshot(@PathVariable Integer mes){

        return ResponseEntity.ok(service.generarSnapshot(mes));
    }
}
