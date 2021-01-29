public class Piloto {

    private String nombre, escuderia;
    private int posicionDeSalida;
    private boolean descalificado;

    public Piloto (){}

    public Piloto(int posicionDeSalida, String nombre, String escuderia) {
        this.posicionDeSalida = posicionDeSalida;
        this.nombre = nombre;
        this.escuderia = escuderia;
        descalificado = false;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEscuderia() {
        return escuderia;
    }

    public void setEscuderia(String escuderia) {
        this.escuderia = escuderia;
    }

    public int getPosicionDeSalida() {
        return posicionDeSalida;
    }

    public void setPosicionDeSalida(int posicionDeSalida) {
        this.posicionDeSalida = posicionDeSalida;
    }

    public boolean isDescalificado() {
        return descalificado;
    }

    public void setDescalificado(boolean descalificado) {
        this.descalificado = descalificado;
    }

    @Override
    public String toString() {
        return " Nombre: " + nombre +
                " Escuderia: " + escuderia +
                " PosicionDeSalida: " + posicionDeSalida +
                " Descalificado: " + descalificado +
                "\n";
    }
}
