package RepasoExamen.Modelo;

/**
 * Esta clase se usa para guardar los datos de los tipos de sueldos del documento CSV a una lista
 */

public class Sueldo {

    String tipo, valor;


    public Sueldo(String tipo, String valor) {
        this.tipo = tipo;
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return tipo + ";" + valor + "\n";
    }
}