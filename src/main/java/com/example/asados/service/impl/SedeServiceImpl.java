package com.example.asados.service.impl;

import com.example.asados.dto.SedeRequestDTO;
import com.example.asados.dto.SedeResponseDTO;
import com.example.asados.dto.SedeStatsDTO;
import com.example.asados.entity.Sede;
import com.example.asados.mapper.SedeMapper;
import com.example.asados.repository.AsadoRepository;
import com.example.asados.repository.SedeRepository;
import com.example.asados.service.SedeService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SedeServiceImpl implements SedeService {

    private final SedeRepository repo;
    private final AsadoRepository asadoRepository;

    public SedeServiceImpl(SedeRepository repo, AsadoRepository asadoRepository) {
        this.repo = repo;
        this.asadoRepository = asadoRepository;
    }

    public SedeResponseDTO crear(SedeRequestDTO dto) {
        Sede t = new Sede();
        t.setNombre(dto.getNombre());
        t.setDescripcion(dto.getDescripcion());
        return SedeMapper.toDTO(repo.save(t));
    }

    public List<SedeResponseDTO> listar() {
        return repo.findAll().stream()
                .map(SedeMapper::toDTO)
                .toList();
    }

    public SedeResponseDTO obtener(Long id) {
        Sede t = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("No encontrado"));
        return SedeMapper.toDTO(t);
    }

    public SedeResponseDTO actualizar(Long id, SedeRequestDTO dto) {
        Sede t = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("No encontrado"));

        t.setNombre(dto.getNombre());
        t.setDescripcion(dto.getDescripcion());

        return SedeMapper.toDTO(repo.save(t));
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }

    @Override
    public List<SedeStatsDTO> getStats() {
        return asadoRepository.getStatsPorSede();
    }

    @Override
    public List<SedeStatsDTO> getStatsByMes(int anio, int mes) {

        LocalDate desde = LocalDate.of(anio, mes, 1);
        LocalDate hasta = desde.withDayOfMonth(desde.lengthOfMonth());

        return asadoRepository.getStatsPorSedeByFecha(desde, hasta);
    }

}
