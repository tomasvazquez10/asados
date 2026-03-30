package com.example.asados.service.impl;

import com.example.asados.entity.Historico;
import com.example.asados.repository.HistoricoRepository;
import com.example.asados.service.HistoricoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HistoricoServiceImpl implements HistoricoService {

    private final HistoricoRepository repository;

    public HistoricoServiceImpl(HistoricoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Historico crear(Historico historico) {
        return repository.save(historico);
    }

    @Override
    public Historico actualizar(Long id, Historico historico) {
        Historico existente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Historico no encontrado"));

        existente.setMes(historico.getMes());
        existente.setAnio(historico.getAnio());
        existente.setCantidad(historico.getCantidad());

        return repository.save(existente);
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Historico obtenerPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Historico no encontrado"));
    }

    @Override
    public List<Historico> listarTodos() {
        return repository.findAll();
    }

    @Override
    public Optional<Historico> obtenerPorMesYAnio(Integer mes, Integer anio) {
        return repository.findByMesAndAnio(mes, anio);
    }
}