package ejercicio2;

import java.util.HashMap;
import java.util.Map;

public class Aereolinea {

    private VerificadorPasajes verificadorPasajes;
    private VerificadorDias verificadorDias;

    public Aereolinea() {}

    public Aereolinea(VerificadorPasajes verificadorPasajes, VerificadorDias verificadorDias) {
        this.verificadorPasajes = verificadorPasajes;
        this.verificadorDias = verificadorDias;
    }

    public String reservaVuelo(String destino, int cantidad, int dia, int mes, int gestion) {
        Map<Integer, String> meses = new HashMap<>();
        meses.put(1,"Enero");
        meses.put(2,"Febrero");
        meses.put(3,"Marzo");
        if(verificadorPasajes.existenPasajes(destino, cantidad)) {
            return "el dia " + verificadorDias.getDay(dia, mes, gestion) + " " + dia;
        }
        return "";
    }

}
