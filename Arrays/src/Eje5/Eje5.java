package Eje5;

import Eje1.Eje1;

public class Eje5 {

    public static boolean existeAnteriormente (int nValores, int datos []) {
        boolean resultado = false;
        int valores = datos[nValores];

        for (int i = nValores - 1; i >= 0; i--) {
            resultado = valores == datos[i];
            if (resultado) break;
        }
        return resultado;
    }

    public static void main(String[] args) {
        Eje1 eje1 = new Eje1();
        Eje5 main = new Eje5();

        int [] datos = eje1.rellenar();

        for (int i = 0; i < datos.length; i++) {
            if (!main.existeAnteriormente(i, datos))
                System.out.println(datos[i]);
        }

    }

}
