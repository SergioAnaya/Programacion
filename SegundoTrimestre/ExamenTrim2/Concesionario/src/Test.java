import Persistencia.LectorVendedores;

public class Test {

    public static void main(String[] args) {

        LectorVendedores lectorVendedores = new LectorVendedores("vendedores.xml");

        System.out.println(lectorVendedores.getMapaVentas());

    }

}
