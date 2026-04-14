package com.example.asados.service.impl;

import com.example.asados.dto.ComensalRequestDTO;
import com.example.asados.dto.ComensalResponseDTO;
import com.example.asados.dto.ComensalStatsDTO;
import com.example.asados.entity.Asado;
import com.example.asados.entity.Comensal;
import com.example.asados.entity.Grupo;
import com.example.asados.mapper.ComensalMapper;
import com.example.asados.repository.AsadoRepository;
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
    private final AsadoRepository asadoRepository;

    public ComensalServiceImpl(ComensalRepository repository,
                               GrupoRepository grupoRepository, AsadoRepository asadoRepository) {
        this.repository = repository;
        this.grupoRepository = grupoRepository;
        this.asadoRepository = asadoRepository;
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
        int totalAsados = asadoRepository.countTotal();

        return getRespuestaStats(raw, totalAsados);
    }

    @Override
    public ComensalStatsDTO getStatsByComensalId(Long comensalId) {
        List<Object[]> raw = repository.getStatsRawByComensalId(comensalId);
        int totalAsados = asadoRepository.countTotal();

        return getRespuestaStats(raw, totalAsados).get(0);
    }


    @Override
    public List<ComensalStatsDTO> getStatsByMes(int anio, int mes) {
        LocalDate desde = LocalDate.of(anio, mes, 1);
        LocalDate hasta = desde.withDayOfMonth(desde.lengthOfMonth());

        List<Object[]> raw = repository.getStatsByFechaRaw(desde, hasta);
        int totalAsados = asadoRepository.countByMes(mes, anio);

        return getRespuestaStats(raw, totalAsados);
    }

    private List<ComensalStatsDTO> getRespuestaStats(List<Object[]> raw, int totalAsados){

        return raw.stream()
                .map(r -> {
                    String nombre = (String) r[0];
                    Long cantidad = (Long) r[1];
                    Long comensalId = (Long) r[2];

                    double porcentaje = totalAsados == 0
                            ? 0
                            : (cantidad * 100.0) / totalAsados;
                    double redondeadoPorc = Math.round(porcentaje * 10.0) / 10.0;


                    Double cantidadKilos = calcularKilosPorComensal(comensalId);
                    Double cantidadKilosRed = Math.round(cantidadKilos * 10.0) / 10.0;

                    return new ComensalStatsDTO(nombre, cantidad, redondeadoPorc, cantidadKilosRed);
                })
                .sorted((a, b) -> Long.compare(b.getCantidadAsados(), a.getCantidadAsados()))
                .toList();
    }

    private Double calcularKilosPorComensal(Long comensalId) {

        List<Asado> asados = asadoRepository.findByComensalId(comensalId);
        double total = 0;

        for (Asado asado : asados) {
            double totalKilos = asado.getCortes()
                    .stream()
                    .mapToDouble(c -> c.getCantidad())
                    .sum();
            int cantComensales = asado.getComensales().size();

            if (cantComensales > 0) {
                total += totalKilos / cantComensales;
            }
        }

        return total;
    }
}