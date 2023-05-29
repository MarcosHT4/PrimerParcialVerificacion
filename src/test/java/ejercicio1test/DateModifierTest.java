package ejercicio1test;

import ejercicio1.DateModifier;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class DateModifierTest {

    private DateModifier dateModifier;

    @BeforeEach
    public void setup() {
        dateModifier = new DateModifier();
    }

    @ParameterizedTest
    @CsvSource({
            "-100,1,1987,Dia invalido",
            "30,1,2004,31/01/2004",
            "300,1,2090,Dia invalido",

            "13,-30,2000,Mes invalido",
            "21,11,2004,22/11/2004",
            "13,1000,2007,Mes invalido",

            "31,02,2004,Dia invalido",
            "31,06,2019,Dia invalido",
            "31,11,2019,Dia invalido",


            "5,5,-1,Gestion invalida",
            "5,5,0,06/05/0000",
            "5,5,1,06/05/0001",

            "31,12,2000,01/01/2001",
            "1,1,2001,02/01/2001",
            "2,1,2001,03/01/2001",

            "14,6,2001,15/06/2001",
            "15,6,2001,16/06/2001",
            "16,6,2001,17/06/2001",

            "30,12,2001,31/12/2001",
            "31,12,2001,01/01/2002",
            "1,1,2002,02/01/2002"
    })
    public void verifyNextDay(int dia, int mes, int gestion, String expectedResult) {
        String actualresult = dateModifier.nextDay(dia, mes, gestion);
        Assertions.assertEquals(expectedResult, actualresult);
    }

}
