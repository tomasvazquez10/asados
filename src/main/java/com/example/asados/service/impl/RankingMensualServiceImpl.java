package com.example.asados.service.impl;

import com.example.asados.entity.Asado;
import com.example.asados.entity.Comensal;
import com.example.asados.entity.RankingMensual;
import com.example.asados.repository.AsadoRepository;
import com.example.asados.repository.RankingMensualRepository;
import com.example.asados.service.RankingMensualService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Year;
import java.util.*;

import static com.example.asados.helper.Helper.calcularMovimiento;
import static com.example.asados.helper.Helper.calcularRacha;

@Service
public class RankingMensualServiceImpl implements RankingMensualService {

    private final RankingMensualRepository repository;
    private final AsadoRepository asadoRepository;

    public RankingMensualServiceImpl(RankingMensualRepository repository, AsadoRepository asadoRepository) {
        this.repository = repository;
        this.asadoRepository = asadoRepository;
    }

    @Override
    @Transactional
    public List<RankingMensual> generarSnapshot(Integer mes) {
        Integer anio = Year.now().getValue();

        if(repository.existsByAnioAndMes(anio, mes)){
            throw new RuntimeException("Snapshot ya generado");
        }

        List<Asado> asados = asadoRepository.findByMes(mes.longValue());

        int totalGeneral = asados.size();
        Map<Comensal,Integer> contador = new HashMap<>();

        for(Asado a: asados){
            for(Comensal c : a.getComensales()){
                contador.merge(c, 1, Integer::sum);
            }
        }

        List<Map.Entry<Comensal,Integer>>
                rankingOrdenado =

                contador.entrySet()
                        .stream()
                        .sorted((a,b)->
                                b.getValue()-a.getValue())
                        .toList();

        List<RankingMensual> snapshot = new ArrayList<>();

        for(int i=0; i<rankingOrdenado.size(); i++) {
            Comensal comensal = rankingOrdenado.get(i).getKey();
            Integer totalAsados = rankingOrdenado.get(i).getValue();
            double porcentaje = totalGeneral== 0?0
                            :(totalAsados*100.0) /totalGeneral;
            int racha = calcularRacha(comensal.getId(), asados);
            String movimiento = calcularMovimiento(comensal.getId(), asados);

            int variacion = 0;
            if(mes!=1){
                Optional<RankingMensual> anterior = repository.findByComensalIdAndAnioAndMes(comensal.getId(), anio, mes-1);
                int finalI = i;
                variacion = anterior.map(a -> a.getRanking()-(finalI +1))
                        .orElse(0);
            }

            RankingMensual rm = new RankingMensual();
            rm.setComensal(comensal);
            rm.setAnio(anio);
            rm.setMes(mes);
            rm.setRanking(i+1);
            rm.setTotalAsados(totalAsados);
            rm.setPorcentaje(Math.round(porcentaje*100)/100.0);
            rm.setRacha(racha);
            rm.setVariacionRanking(variacion);
            rm.setMovimiento(movimiento);
            snapshot.add(rm);
        }

        return repository.saveAll(snapshot);
    }

    @Override
    public List<RankingMensual> getAll() {
        return repository.findAll(Sort.by(Sort.Direction.ASC, "anio", "mes", "ranking"));
    }

    @Override
    public List<RankingMensual> getByMes(Integer mes) {
        return repository.findByMesOrderByRankingAsc(mes);
    }

    @Override
    public List<RankingMensual> getByComensalId(Long comensalId) {
        return repository.findByComensalIdOrderByAnioAscMesAsc(comensalId);
    }
}
