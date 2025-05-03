package ual.hmis;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import ual.hmis.sesion05.MezclaLineal;

public class MezclaLinealTest {

    @ParameterizedTest
    @CsvSource({
        "'', '', ''",
        "'', '1;2;3', '1;2;3'",
        "'4;5;6', '', '4;5;6'",
        "'1;3;5', '2;4;6', '1;2;3;4;5;6'",
        "'2;4;6', '1;3;5', '1;2;3;4;5;6'",
        "'1;2;2', '2;3', '1;2;2;2;3'",
        "'1', '2', '1;2'",
        "'5', '3', '3;5'",
        "'1;1;1', '1;1', '1;1;1;1;1'"
    })
    public void testMezclaLineal(String arr1Str, String arr2Str, String expectedStr) {
        int[] arr1 = parseArray(arr1Str);
        int[] arr2 = parseArray(arr2Str);
        int[] expected = parseArray(expectedStr);

        MezclaLineal mezcla = new MezclaLineal(arr1, arr2);
        int[] resultado = mezcla.mezcla();

        assertArrayEquals(expected, resultado, "La mezcla no es correcta.");
    }

    private int[] parseArray(String str) {
        if (str == null || str.trim().isEmpty()) return new int[0];
        return Arrays.stream(str.split(";")).mapToInt(Integer::parseInt).toArray();
    }
}
