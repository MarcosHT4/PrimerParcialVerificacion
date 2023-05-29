package ejercicio1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateModifier {

    public String nextDay(int dia, int mes, int gestion) {

        if(gestion < 0) {
            return "Gestion invalida";
        }

        if(mes <= 0 || mes >=13) {
            return "Mes invalido";
        }

        if(dia <1) {
            return "Dia invalido";
        }

        if(mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
            if(dia > 31) {
                return "Dia invalido";
            }
        } else if(mes == 4 || mes == 6 || mes == 9 || mes == 11) {
            if(dia > 30) {
                return "Dia invalido";
            }
        } else if(mes == 2) {
            if(dia > 29) {
                return "Dia invalido";
            }
        }


        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate parsedDate = LocalDate.of(gestion, mes, dia);
        LocalDate tomorrow = parsedDate.plusDays(1);
        if(gestion == 0) {
            String[] fechaFinal = tomorrow.format(dtf).split("/");
            return fechaFinal[0] + "/" + fechaFinal[1] + "/" + "0000";
        }
        return tomorrow.format(dtf);
    }

}
