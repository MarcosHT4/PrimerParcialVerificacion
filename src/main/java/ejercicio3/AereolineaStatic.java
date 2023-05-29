package ejercicio3;

import ejercicio2.VerificadorDias;

import java.util.HashMap;
import java.util.Map;

public class AereolineaStatic {

    public String reservaVuelo(String destino, int cantidad, int dia, int mes, int gestion) throws Exception {

        if(gestion < 0) {
            throw new Exception();
        }

        if(mes <= 0 || mes >=13) {
            throw new Exception();
        }

        if(dia <1) {
            throw new Exception();
        }

        if(mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
            if(dia > 31) {
                throw new Exception();
            }
        } else if(mes == 4 || mes == 6 || mes == 9 || mes == 11) {
            if(dia > 30) {
                throw new Exception();
            }
        } else if(mes == 2) {
            if(dia > 29) {
                throw new Exception();
            }
        }



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
