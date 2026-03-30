package com.example.asados.service;

import com.example.asados.entity.Historico;

import java.util.List;
import java.util.Optional;

public interface HistoricoService {

    Historico crear(Historico historico);

    Historico actualizar(Long id, Historico historico);

    void eliminar(Long id);

    Historico obtenerPorId(Long id);

    List<Historico> listarTodos();

    Optional<Historico> obtenerPorMesYAnio(Integer mes, Integer anio);
}
