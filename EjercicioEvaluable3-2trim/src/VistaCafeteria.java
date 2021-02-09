import java.util.LinkedList;

public class VistaCafeteria {

    Interfaz interfaz;
    Cafeteria cafeteria;

    /*static void programaPrincipal (int accion) {
        switch (accion) {
            case Interfaz.OP_CONSULTAR_MESAS:
                break;
        }
    }*/

    public static void main(String[] args) {
        Interfaz interfaz = new Interfaz();
        Mesa mesa = new Mesa();
        Cafeteria cafeteria = new Cafeteria();

        interfaz.menuNumeroMesasAbiertas();
        cafeteria.abrirMesasIniciales(interfaz.leerRespuestaMenuNumeroMesasAbiertas());


        System.out.println(cafeteria.mesas);
    }
}