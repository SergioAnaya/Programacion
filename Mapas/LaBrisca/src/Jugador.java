public class Jugador {

    String nickName;
    String nombre;
    String apellidos;
    int edad;
    int partidasGanadas;

    public Jugador(String nickName, String nombre, String apellidos, int edad, int partidasGanadas) {
        this.nickName = nickName;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.partidasGanadas = partidasGanadas;
    }

    public int getPartidasGanadas() {
        return partidasGanadas;
    }

    public String getNombreApellido(){
        return this.nombre+" "+this.apellidos;
    }

    public void anotarVictoria()
    {
        this.partidasGanadas++;
    }

    @Override
    public String toString() {
        return "\nNickName: " + nickName +
                "\nNombre: " + nombre +
                "\nApellidos: " + apellidos +
                "\nEdad: " + edad +
                "\nPartidasGanadas: " + partidasGanadas +
                "\n";
    }
}