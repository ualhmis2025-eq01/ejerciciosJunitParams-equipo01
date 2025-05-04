package ual.hmis.sesion05.ejercicio4;

public class Ejercicio4 {
    private int[] array1;
    private int[] array2;
    private int[] resultado;

    public Ejercicio4(int[] array1, int[] array2) {
        this.array1 = array1;
        this.array2 = array2;
        if(array1.length == 0 && array2.length == 0) {
            resultado = new int[0];
        } else if (array1.length == 0) {
            resultado = new int[array2.length];
            System.arraycopy(array2, 0, resultado, 0, array2.length);
        } else if (array2.length == 0) {
            resultado = new int[array1.length];
            System.arraycopy(array1, 0, resultado, 0, array1.length);
        } else {
            resultado = new int[array1.length + array2.length];
        }
    }

    public int[] mezcla() {
        int i = 0, j = 0, k = 0;

        if(resultado.length == 0) return resultado;

        while (i < array1.length && j < array2.length) {
            if (array1[i] < array2[j]) {
                resultado[k++] = array1[i++];
            } else {
                resultado[k++] = array2[j++];
            }
        }

        while (i < array1.length) {
            resultado[k++] = array1[i++];
        }

        while (j < array2.length) {
            resultado[k++] = array2[j++];
        }

        return resultado;
    }
    
}
