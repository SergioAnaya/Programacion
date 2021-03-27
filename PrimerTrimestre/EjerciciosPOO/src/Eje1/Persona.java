package Eje1;

public class Persona {

    /**
     * Vamos a crear una clase llamada Persona. Sus atributos son: nombre, edad y DNI.
     * Construye los siguientes métodos para la clase:
     * Un constructor, donde los datos pueden estar vacíos.
     * Los setters y getters para cada uno de los atributos.
     * Hay que validar las entradas de datos.
     * mostrar(): Muestra los datos de la persona.
     * esMayorDeEdad(): Devuelve un valor lógico indicando si es mayor de edad.
     * @author  Antonio Caballero
     * @version 1.0
     */

    // Atributos

    private String nombre, dni;
    private int edad;

    // Constructores

    public Persona () {}

    public Persona (String nombre,int edad, String dni) throws Exception {
        this.setNombre(nombre);
        this.setEdad(edad);
        this.setDni(dni);
    }

    // Setters

    public void setNombre (String nombre) throws Exception {
        if (nombre.length() > 0) this.nombre = nombre;
        else throw new Exception("El nombre no puede ser vacio");
    }

    public void setDni (String dni) throws Exception {
        if (this.validarDni(dni)) this.dni=dni;
        else throw new Exception("No es un dni correcto");
    }

    public void setEdad (int edad) throws Exception {
        if (edad > 0) this.edad=edad;
        else throw new Exception("La edad debe ser mayor de cero");
    }

    // Getters

    public String getNombre(){ return this.nombre; }
    public String getDni() { return this.dni; }
    public int getEdad()  { return this.edad; }

    // Validación del DNI

    private Boolean validarDni (String dni) {
        String expRegDni = "[0-9]{8}[A-Z]";
        return dni.matches(expRegDni);
    }

    // Validación de mayoría de edad

    public Boolean esMayorDeEdad () {
        return  (this.getEdad() >= 18);
    }

    // Mostrar los datos

    public String mostrar (){
        return "Nombre=" + this.getNombre() + "\n"+
                "Edad=" + this.getEdad() + "\n"+
                "Dni=" + this.getDni() + "\n";
    }

}
