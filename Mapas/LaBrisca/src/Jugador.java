public class Jugador {

    String nickName;
    String nombre;
    String apellidos;
    int edad;
    int partidasGanadas;

    public Jugador(String nombre, String apellidos, int edad, int partidasGanadas) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.partidasGanadas = partidasGanadas;
    }

    public Jugador(String nickName, String nombre, String apellidos, int edad, int partidasGanadas) {
        this.nickName = nickName;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.partidasGanadas = partidasGanadas;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getPartidasGanadas() {
        return partidasGanadas;
    }

    public void setPartidasGanadas(int partidasGanadas) {
        this.partidasGanadas = partidasGanadas;
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
