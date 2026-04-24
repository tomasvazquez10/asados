package com.example.asados.helper;

import com.example.asados.entity.Asado;

import java.util.List;

public class Helper {

    public static Integer calcularRacha(Long comensalId, List<Asado> asados){

        int streak=0;

        for(Asado a: asados){
            boolean asistio = a.getComensales().stream()
                            .anyMatch(c->c.getId().equals(comensalId));
            if(asistio){
                streak++;
            }else{
                break;
            }
        }
        return streak;
    }

    public static String calcularMovimiento(Long comensalId, List<Asado> asados){

        List<Asado> ultimos3 = asados.stream().limit(3).toList();

        long asistencias = ultimos3.stream().filter(a ->
                                a.getComensales()
                                        .stream()
                                        .anyMatch(c->
                                                c.getId().equals(comensalId))
                        ).count();

        if(asistencias == 3)
            return "SUPER";
        if(asistencias == 2)
            return "UP";
        if(asistencias == 1)
            return "DOWN";
        return "OUT";
    }
}
