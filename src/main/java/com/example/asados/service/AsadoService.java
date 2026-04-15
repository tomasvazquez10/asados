package com.example.asados.service;

import com.example.asados.dto.AsadoMesResumenDTO;
import com.example.asados.dto.AsadoRequestDTO;
import com.example.asados.dto.AsadoResponseDTO;
import com.example.asados.dto.AsadoSimpleRequestDTO;

import java.time.LocalDate;
import java.util.List;

public interface AsadoService {

    AsadoResponseDTO crear(AsadoRequestDTO dto);

    List<AsadoResponseDTO> listar();

    AsadoResponseDTO obtener(Long id);

    List<AsadoResponseDTO> getByRangoFechas(LocalDate desde, LocalDate hasta);

    List<AsadoResponseDTO> getByMes(int anio, int mes);

    AsadoMesResumenDTO getResumenMes(int anio, int mes);

    void eliminar(Long id);

    AsadoResponseDTO crearDesdeSimple(AsadoSimpleRequestDTO request);

    List<AsadoResponseDTO> getAsadosByComensalId(Long comensalId);
}


