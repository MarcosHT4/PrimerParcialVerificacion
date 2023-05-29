package ejercicio3test;


import ejercicio2.Aereolinea;
import ejercicio3.AereolineaStatic;
import ejercicio3.VerificadorDiasStatic;
import ejercicio3.VerificadorPasajesStatic;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

public class AereolineaStaticTest {

    private AereolineaStatic aereolineaStatic;
    private MockedStatic<VerificadorPasajesStatic> overrideVerificadorPasajes;
    private MockedStatic<VerificadorDiasStatic> overrideVerificadorDias;

    @BeforeEach
    public void setup() {
        aereolineaStatic = new AereolineaStatic();
        overrideVerificadorDias = Mockito.mockStatic(VerificadorDiasStatic.class);
        overrideVerificadorPasajes = Mockito.mockStatic(VerificadorPasajesStatic.class);
    }

    @AfterEach
    public void cleanup() {
        overrideVerificadorDias.close();
        overrideVerificadorPasajes.close();
    }

    //Se probaran todos los dias de la semana, y la mitad de los meses del año.
    @ParameterizedTest
    @CsvSource({
            "Santa Cruz,10,10,10,2023,no existen suficientes pasajes para Santa Cruz",
            "La Paz,2,29,5,2023,el dia Lunes 29 Mayo 2023 existen 2 pasajes para La Paz",
            "Cochabamba,5,6,2,2023,el dia Martes 6 Febrero 2023 existen 5 pasajes para Cochabamba",
            "Beni,15,20,7,2023,el dia Miercoles 20 Julio 2023 existen 15 pasajes para Beni",
            "Pando,21,21,4,2023,el dia Jueves 21 Abril 2023 existen 21 pasajes para Pando",
            "Tarija,21,15,4,2023,el dia Viernes 15 Abril 2023 existen 21 pasajes para Tarija",
            "Potosi,2,2,2,2023,el dia Sabado 2 Febrero 2023 existen 2 pasajes para Potosi",
            "Sucre,3,3,3,2023,el dia Domingo 3 Marzo 2023 existen 3 pasajes para Sucre",
            "Chile,15,15,1,2023, el dia Viernes 15 Enero 2023 existen 15 pasajes para Chile",
            "Colombia,15,15,2,2023, el dia Viernes 15 Febrero 2023 existen 15 pasajes para Colombia",
            "Argentina,15,15,5,2023,el dia Viernes 15 Mayo 2023 existen 15 pasajes para Argentina",
            "Cuba,15,15,6,2023,el dia Viernes 15 Junio 2023 existen 15 pasajes para Cuba",



    })

    public void verifyReservaVuelo(String destino, int cantidad, int dia, int mes, int gestion, String expectedResult) throws Exception {
        overrideVerificadorPasajes.when(() -> VerificadorPasajesStatic.existenPasajes("Santa Cruz", 10)).thenReturn(false);
        overrideVerificadorPasajes.when(() -> VerificadorPasajesStatic.existenPasajes("La Paz", 2)).thenReturn(true);
        overrideVerificadorPasajes.when(() -> VerificadorPasajesStatic.existenPasajes("Cochabamba", 5)).thenReturn(true);
        overrideVerificadorPasajes.when(() -> VerificadorPasajesStatic.existenPasajes("Beni",15)).thenReturn(true);
        overrideVerificadorPasajes.when(() -> VerificadorPasajesStatic.existenPasajes("Pando",21)).thenReturn(true);
        overrideVerificadorPasajes.when(() -> VerificadorPasajesStatic.existenPasajes("Tarija",21)).thenReturn(true);
        overrideVerificadorPasajes.when(() -> VerificadorPasajesStatic.existenPasajes("Potosi",2)).thenReturn(true);
        overrideVerificadorPasajes.when(() -> VerificadorPasajesStatic.existenPasajes("Sucre",3)).thenReturn(true);
        overrideVerificadorPasajes.when(() -> VerificadorPasajesStatic.existenPasajes("Chile",15)).thenReturn(true);
        overrideVerificadorPasajes.when(() -> VerificadorPasajesStatic.existenPasajes("Colombia",15)).thenReturn(true);
        overrideVerificadorPasajes.when(() -> VerificadorPasajesStatic.existenPasajes("Argentina",15)).thenReturn(true);
        overrideVerificadorPasajes.when(() -> VerificadorPasajesStatic.existenPasajes("Cuba",15)).thenReturn(true);

        overrideVerificadorDias.when(() -> VerificadorDiasStatic.getDay(29,5,2023)).thenReturn("Lunes");
        overrideVerificadorDias.when(() -> VerificadorDiasStatic.getDay(6,2,2023)).thenReturn("Martes");
        overrideVerificadorDias.when(() -> VerificadorDiasStatic.getDay(20,7,2023)).thenReturn("Miercoles");
        overrideVerificadorDias.when(() -> VerificadorDiasStatic.getDay(21,4,2023)).thenReturn("Jueves");
        overrideVerificadorDias.when(() -> VerificadorDiasStatic.getDay(15,4,2023)).thenReturn("Viernes");
        overrideVerificadorDias.when(() -> VerificadorDiasStatic.getDay(2,2,2023)).thenReturn("Sabado");
        overrideVerificadorDias.when(() -> VerificadorDiasStatic.getDay(3,3,2023)).thenReturn("Domingo");
        overrideVerificadorDias.when(() -> VerificadorDiasStatic.getDay(15,1,2023)).thenReturn("Viernes");
        overrideVerificadorDias.when(() -> VerificadorDiasStatic.getDay(15,2,2023)).thenReturn("Viernes");
        overrideVerificadorDias.when(() -> VerificadorDiasStatic.getDay(15,5,2023)).thenReturn("Viernes");
        overrideVerificadorDias.when(() -> VerificadorDiasStatic.getDay(15,6,2023)).thenReturn("Viernes");

        String actualResult = aereolineaStatic.reservaVuelo(destino, cantidad, dia, mes, gestion);
        Assertions.assertEquals(expectedResult, actualResult);

    }

    @ParameterizedTest
    @CsvSource(
            {"Santa Cruz,2,-2,2,2022",
                    "Cochambamba,3,15,-4,2022",
                    "Peru, 10,15,10,-4",
                    "Pando,68,31,2,2022",
                    "Dubai,-40,29,3,2022"


            }
    )
    public void verifyReservaVueloException(String destino, int cantidad, int dia, int mes, int gestion) throws Exception {
        Assertions.assertThrows(Exception.class, () -> {aereolineaStatic.reservaVuelo(destino, cantidad, dia, mes, gestion);});

    }

}
