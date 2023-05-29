package ejercicio2test;

import ejercicio2.Aereolinea;
import ejercicio2.VerificadorDias;
import ejercicio2.VerificadorPasajes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.Mockito;

public class AereolineaTest {

    private Aereolinea aereolinea;
    private VerificadorPasajes verificadorPasajes;
    private VerificadorDias verificadorDias;


    @BeforeEach
    public void setup() {
        verificadorPasajes = Mockito.mock(VerificadorPasajes.class);
        verificadorDias = Mockito.mock(VerificadorDias.class);

    }


    @ParameterizedTest
    @CsvSource({
            "Santa Cruz,10,10,10,2023,no existen suficientes pasajes para Santa Cruz",
            "La Paz,2,29,5,2023,el dia Lunes 29 Mayo 2023 existen 2 pasajes para La Paz",
            "Cochabamba,5,6,2,2023,el dia Martes 6 Febrero 2023 existen 5 pasajes para Cochabamba",
            "Beni,15,20,7,2023,el dia Miercoles 20 Julio 2023 existen 15 pasajes para Beni",
            "Pando,21,21,4,2023,el dia Jueves 21 Abril 2023 existen 21 pasajes para Pando",
            "Tarija,21,15,4,2023,el dia Viernes 15 Abril 2023 existen 21 pasajes para Tarija",
            "Potosi,2,2,2,2023,el dia Sabado 2 Febrero 2023 existen 2 pasajes para Potosi",
            "Sucre,3,3,3,2023,el dia Domingo 3 Marzo 2023 existen 3 pasajes para Sucre"


    })
    public void verifyReservaVuelo(String destino, int cantidad, int dia, int mes, int gestion, String expectedResult) {
        Mockito.when(verificadorPasajes.existenPasajes("La Paz", 2)).thenReturn(true);
        Mockito.when(verificadorPasajes.existenPasajes("Cochabamba", 5)).thenReturn(true);
        Mockito.when(verificadorPasajes.existenPasajes("Santa Cruz",10)).thenReturn(false);
        Mockito.when(verificadorPasajes.existenPasajes("Beni",15)).thenReturn(true);
        Mockito.when(verificadorPasajes.existenPasajes("Pando",21)).thenReturn(true);
        Mockito.when(verificadorPasajes.existenPasajes("Tarija",21)).thenReturn(true);
        Mockito.when(verificadorPasajes.existenPasajes("Potosi",2)).thenReturn(true);
        Mockito.when(verificadorPasajes.existenPasajes("Sucre",3)).thenReturn(true);


        Mockito.when(verificadorDias.getDay(29,5,2023)).thenReturn("Lunes");
        Mockito.when(verificadorDias.getDay(6,2,2023)).thenReturn("Martes");
        Mockito.when(verificadorDias.getDay(20,7,2023)).thenReturn("Miercoles");
        Mockito.when(verificadorDias.getDay(21,4,2023)).thenReturn("Jueves");
        Mockito.when(verificadorDias.getDay(15,4,2023)).thenReturn("Viernes");
        Mockito.when(verificadorDias.getDay(2,2,2023)).thenReturn("Sabado");
        Mockito.when(verificadorDias.getDay(3,3,2023)).thenReturn("Domingo");


        aereolinea = new Aereolinea(verificadorPasajes, verificadorDias);
        String actualResult = aereolinea.reservaVuelo(destino, cantidad, dia, mes, gestion);
        Assertions.assertEquals(expectedResult, actualResult);

    }

}
