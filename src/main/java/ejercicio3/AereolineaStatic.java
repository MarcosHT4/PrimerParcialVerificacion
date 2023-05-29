package ejercicio3;

import ejercicio2.VerificadorDias;

import java.util.HashMap;
import java.util.Map;

public class AereolineaStatic {

    public String reservaVuelo(String destino, int cantidad, int dia, int mes, int gestion) {
        Map<Integer, String> meses = new HashMap<>();
        meses.put(1,"Enero");
        meses.put(2,"Febrero");
        meses.put(3,"Marzo");
        meses.put(4,"Abril");
        meses.put(5,"Mayo");
        meses.put(6,"Junio");
        meses.put(7,"Julio");
        meses.put(8,"Agosto");
        meses.put(9,"Septiembre");
        meses.put(10,"Octubre");
        meses.put(11,"Noviembre");
        meses.put(12,"Diciembre");
        if(VerificadorPasajesStatic.existenPasajes(destino, cantidad)) {
            return "el dia " + VerificadorDiasStatic.getDay(dia, mes, gestion) + " " + dia + " " + meses.get(mes) + " " + gestion + " existen " + cantidad + " pasajes para " + destino;
        } else {
            return "no existen suficientes pasajes para " + destino;
        }
    }

}
