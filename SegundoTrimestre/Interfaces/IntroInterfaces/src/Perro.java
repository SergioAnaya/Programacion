public class Perro implements Animal {
    @Override
    public String habla() {
        return "Guau";
    }

    @Override
    public String getNombre() {
        return "Perro";
    }
}