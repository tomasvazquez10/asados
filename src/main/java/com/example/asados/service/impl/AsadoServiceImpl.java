package com.example.asados.service.impl;

import com.example.asados.dto.AsadoRequestDTO;
import com.example.asados.dto.AsadoResponseDTO;
import com.example.asados.dto.CorteDTO;
import com.example.asados.entity.Asado;
import com.example.asados.entity.Comensal;
import com.example.asados.entity.Corte;
import com.example.asados.mapper.CorteMapper;
import com.example.asados.repository.*;
import com.example.asados.service.AsadoService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AsadoServiceImpl implements AsadoService {

    private final AsadoRepository asadoRepo;
    private final GrupoRepository grupoRepo;
    private final SedeRepository sedeRepo;
    private final TipoAsadoRepository tipoRepo;
    private final ComensalRepository comensalRepo;
    private final CorteNombreRepository corteNombreRepo;

    public AsadoServiceImpl(AsadoRepository asadoRepo,
                            GrupoRepository grupoRepo,
                            SedeRepository sedeRepo,
                            TipoAsadoRepository tipoRepo,
                            ComensalRepository comensalRepo,
                            CorteNombreRepository corteNombreRepo) {
        this.asadoRepo = asadoRepo;
        this.grupoRepo = grupoRepo;
        this.sedeRepo = sedeRepo;
        this.tipoRepo = tipoRepo;
        this.comensalRepo = comensalRepo;
        this.corteNombreRepo = corteNombreRepo;
    }

    @Override
    public AsadoResponseDTO crear(AsadoRequestDTO dto) {

        var grupo = grupoRepo.findById(dto.getGrupoId())
                .orElseThrow(() -> new RuntimeException("Grupo no existe"));

        var sede = sedeRepo.findById(dto.getSedeId())
                .orElseThrow(() -> new RuntimeException("Sede no existe"));

        var tipo = tipoRepo.findById(dto.getTipoId())
                .orElseThrow(() -> new RuntimeException("TipoAsado no existe"));

        // VALIDAR COMENSALES
        List<Comensal> comensales = comensalRepo.findAllById(dto.getComensalesIds());

        if (comensales.size() != dto.getComensalesIds().size()) {
            throw new RuntimeException("Algún comensal no existe");
        }

        // validar que pertenezcan al grupo
        for (Comensal c : comensales) {
            if (!c.getGrupo().getId().equals(grupo.getId())) {
                throw new RuntimeException("Comensal no pertenece al grupo");
            }
        }

        Asado asado = new Asado();
        asado.setFecha(dto.getFecha());
        asado.setPrecio(dto.getPrecio());
        asado.setGrupo(grupo);
        asado.setSede(sede);
        asado.setTipo(tipo);
        asado.setComensales(comensales);

        // CREAR CORTES
        List<Corte> cortes = dto.getCortes().stream().map(c -> {

            var corteNombre = corteNombreRepo.findById(c.getCorteNombreId())
                    .orElseThrow(() -> new RuntimeException("CorteNombre no existe"));

            Corte corte = new Corte();
            corte.setCantidad(c.getCantidad());
            corte.setCorteNombre(corteNombre);
            corte.setAsado(asado);

            return corte;

        }).toList();

        asado.setCortes(cortes);

        return toDTO(asadoRepo.save(asado));
    }

    @Override
    public List<AsadoResponseDTO> listar() {
        return asadoRepo.findAll().stream()
                .map(this::toDTO)
                .toList();
    }

    @Override
    public AsadoResponseDTO obtener(Long id) {
        Asado a = asadoRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Asado no encontrado"));

        return toDTO(a);
    }

    @Override
    public void eliminar(Long id) {
        asadoRepo.deleteById(id);
    }

    private AsadoResponseDTO toDTO(Asado a) {
        AsadoResponseDTO dto = new AsadoResponseDTO();

        dto.setId(a.getId());
        dto.setFecha(a.getFecha());
        dto.setPrecio(a.getPrecio());

        dto.setGrupoNombre(a.getGrupo().getNombre());
        dto.setSedeNombre(a.getSede().getNombre());
        dto.setTipoNombre(a.getTipo().getNombre());

        dto.setComensales(
                a.getComensales().stream()
                        .map(Comensal::getNombre)
                        .toList()
        );
        List<CorteDTO> cortesDTO = new ArrayList<>();
        for(Corte c: a.getCortes()){
            cortesDTO.add(CorteMapper.toCorteDTO(c));
        }
        dto.setCortes(cortesDTO);

        return dto;
    }
}
