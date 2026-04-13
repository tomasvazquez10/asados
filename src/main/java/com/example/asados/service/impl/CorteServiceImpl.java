package com.example.asados.service.impl;

import com.example.asados.dto.CorteNombreStatsDTO;
import com.example.asados.dto.CorteRequestDTO;
import com.example.asados.dto.CorteResponseDTO;
import com.example.asados.entity.Corte;
import com.example.asados.mapper.CorteMapper;
import com.example.asados.repository.AsadoRepository;
import com.example.asados.repository.CorteNombreRepository;
import com.example.asados.repository.CorteRepository;
import com.example.asados.service.CorteService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CorteServiceImpl implements CorteService {

    private final CorteRepository repository;
    private final CorteNombreRepository corteNombreRepository;
    private final AsadoRepository asadoRepository;

    public CorteServiceImpl(CorteRepository repository,
                            CorteNombreRepository corteNombreRepository,
                            AsadoRepository asadoRepository) {
        this.repository = repository;
        this.corteNombreRepository = corteNombreRepository;
        this.asadoRepository = asadoRepository;
    }

    @Override
    public CorteResponseDTO crear(CorteRequestDTO dto) {

        var corteNombre = corteNombreRepository.findById(dto.getCorteNombreId())
                .orElseThrow(() -> new RuntimeException("CorteNombre no existe"));

        var asado = asadoRepository.findById(dto.getAsadoId())
                .orElseThrow(() -> new RuntimeException("Asado no existe"));

        Corte c = new Corte();
        c.setCantidad(dto.getCantidad());
        c.setCorteNombre(corteNombre);
        c.setAsado(asado);

        return CorteMapper.toDTO(repository.save(c));
    }

    @Override
    public List<CorteResponseDTO> listar() {
        return repository.findAll()
                .stream()
                .map(CorteMapper::toDTO)
                .toList();
    }

    @Override
    public CorteResponseDTO obtener(Long id) {
        Corte c = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comensal no encontrado"));

        return CorteMapper.toDTO(c);
    }

    @Override
    public CorteResponseDTO actualizar(Long id, CorteRequestDTO dto) {

        Corte c = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Corte no encontrado"));

        var corteNombre = corteNombreRepository.findById(dto.getCorteNombreId())
                .orElseThrow(() -> new RuntimeException("CorteNombre no existe"));

        var asado = asadoRepository.findById(dto.getAsadoId())
                .orElseThrow(() -> new RuntimeException("Asado no existe"));

        c.setCantidad(dto.getCantidad());
        c.setCorteNombre(corteNombre);
        c.setAsado(asado);

        return CorteMapper.toDTO(repository.save(c));
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<CorteNombreStatsDTO> getStats() {
        List<CorteNombreStatsDTO> listaStats = repository.getStats();
        return redondearListaStats(listaStats);
    }

    @Override
    public List<CorteNombreStatsDTO> getStatsByMes(int anio, int mes) {
        LocalDate desde = LocalDate.of(anio, mes, 1);
        LocalDate hasta = desde.withDayOfMonth(desde.lengthOfMonth());
        List<CorteNombreStatsDTO> listaStats = repository.getStatsByFecha(desde, hasta);

        return redondearListaStats(listaStats);
    }

    private List<CorteNombreStatsDTO> redondearListaStats(List<CorteNombreStatsDTO> listaStats){
        listaStats.forEach(stat -> {
            double redondeado = Math.round(stat.getTotalKilos() * 10.0) / 10.0;
            stat.setTotalKilos(redondeado);
        });
        return listaStats;
    }
}
