package com.example.asados.service.impl;

import com.example.asados.dto.ComensalRequestDTO;
import com.example.asados.dto.ComensalResponseDTO;
import com.example.asados.dto.ComensalStatsDTO;
import com.example.asados.entity.Comensal;
import com.example.asados.entity.Grupo;
import com.example.asados.mapper.ComensalMapper;
import com.example.asados.repository.ComensalRepository;
import com.example.asados.repository.GrupoRepository;
import com.example.asados.service.ComensalService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ComensalServiceImpl implements ComensalService {

    private final ComensalRepository repository;
    private final GrupoRepository grupoRepository;

    public ComensalServiceImpl(ComensalRepository repository,
                               GrupoRepository grupoRepository) {
        this.repository = repository;
        this.grupoRepository = grupoRepository;
    }

    @Override
    public ComensalResponseDTO crear(ComensalRequestDTO dto) {

        Grupo grupo = grupoRepository.findById(dto.getGrupoId())
                .orElseThrow(() -> new RuntimeException("Grupo no existe"));

        Comensal c = new Comensal();
        c.setUsuario(dto.getUsuario());
        c.setNombre(dto.getNombre());
        c.setGrupo(grupo);

        return ComensalMapper.toDTO(repository.save(c));
    }

    @Override
    public List<ComensalResponseDTO> listar() {
        return repository.findAll()
                .stream()
                .map(ComensalMapper::toDTO)
                .toList();
    }

    @Override
    public ComensalResponseDTO obtener(Long id) {
        Comensal c = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comensal no encontrado"));

        return ComensalMapper.toDTO(c);
    }

    @Override
    public ComensalResponseDTO actualizar(Long id, ComensalRequestDTO dto) {

        Comensal c = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comensal no encontrado"));

        Grupo grupo = grupoRepository.findById(dto.getGrupoId())
                .orElseThrow(() -> new RuntimeException("Grupo no existe"));

        c.setUsuario(dto.getUsuario());
        c.setNombre(dto.getNombre());
        c.setGrupo(grupo);

        return ComensalMapper.toDTO(repository.save(c));
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<ComensalStatsDTO> getStats() {

        List<Object[]> raw = repository.getStatsRaw();

        return getRespuestaStats(raw);
    }


    @Override
    public List<ComensalStatsDTO> getStatsByMes(int anio, int mes) {
        LocalDate desde = LocalDate.of(anio, mes, 1);
        LocalDate hasta = desde.withDayOfMonth(desde.lengthOfMonth());

        List<Object[]> raw = repository.getStatsByFechaRaw(desde, hasta);

        return getRespuestaStats(raw);
    }

    private List<ComensalStatsDTO> getRespuestaStats(List<Object[]> raw){
        long totalAsados = raw.stream()
                .mapToLong(r -> (Long) r[1])
                .sum();

        return raw.stream()
                .map(r -> {
                    String nombre = (String) r[0];
                    Long cantidad = (Long) r[1];

                    double porcentaje = totalAsados == 0
                            ? 0
                            : (cantidad * 100.0) / totalAsados;

                    return new ComensalStatsDTO(nombre, cantidad, porcentaje);
                })
                .sorted((a, b) -> Long.compare(b.getCantidadAsados(), a.getCantidadAsados()))
                .toList();
    }
}