import Modelo.Torre;

import java.util.Scanner;

public class TableroTorres {

    Scanner teclado = new Scanner(System.in);

    Torre torre1;
    Torre torre2;

    public void menu () throws Exception {
        System.out.println("Ficha 1: ");
        System.out.println("Introduce el valor X: ");
        int valorX = teclado.nextInt();
        if (valorX <= 8 && valorX >= 1) {
            System.out.println("Introduce el valor Y: ");
            int valorY = teclado.nextInt();
            if (valorY <= 8 && valorY >= 1) {
                torre1 = new Torre(valorX, valorY);
            } else throw new Exception("Introduce un valor entre 1 y 8");

            System.out.println("Ficha 2: ");
            System.out.println("Introduce el valor X: ");
            valorX = teclado.nextInt();
            if (valorX <= 8 && valorX >= 1) {
                System.out.println("Introduce el valor Y: ");
                valorY = teclado.nextInt();
                if (valorY <= 8 && valorY >= 1) {
                    torre2 = new Torre(valorX, valorY);
                } else throw new Exception("Introduce un valor entre 1 y 8");
            } else throw new Exception("Introduce un valor entre 1 y 8");

        } else throw new Exception("Introduce un valor entre 1 y 8");
    }

    public boolean seEliminan (){
        if (torre1.getX() == torre2.getX() || torre1.getY() == torre2.getY()) {
            return true;
        } else return false;
    }

    public void ejecutar () throws Exception {
        menu();
        System.out.println(seEliminan());
    }

    public static void main(String[] args) throws Exception {

        TableroTorres tableroTorres = new TableroTorres();

        tableroTorres.ejecutar();

    }
}