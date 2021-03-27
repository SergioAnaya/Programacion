public class MostrarAnimal {

    public void mostrar (Animal animal) {
        System.out.println("El animal " + animal.getNombre() + " dice " + animal.habla());
    }

    public static void main(String[] args) {
        Perro perro = new Perro();

        MostrarAnimal mostrarAnimal = new MostrarAnimal();

        mostrarAnimal.mostrar(perro);
    }

}