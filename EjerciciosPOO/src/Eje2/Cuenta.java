package Eje2;

import Eje1.Persona;

public class Cuenta {

    /**
     * Crea una clase llamada Cuenta que tendrá los siguientes atributos:
     * titular (que es una persona) y cantidad (puede tener decimales).
     * El titular será obligatorio y la cantidad es opcional.
     * Construye los siguientes métodos para la clase
     * Un constructor, donde los datos pueden estar vacíos.
     * Los setters y getters para cada uno de los atributos.
     * El atributo no se puede modificar directamente, sólo ingresando o retirando dinero.
     * mostrar(): Muestra los datos de la cuenta.
     * ingresar(cantidad): se ingresa una cantidad a la cuenta, si la cantidad introducida es negativa, no se hará nada.
     * retirar(cantidad): se retira una cantidad a la cuenta. La cuenta puede estar en números rojos.
     * @author  Antonio Caballero
     * @version 1.0
     **/

    // Atributos

    protected Persona persona;
    private double cantidad;

    // Constructores

    public Cuenta (Persona p) throws Exception {
        this.persona = new Persona(p.getNombre(), p.getEdad(), p.getDni());
        this.setCantidad(0);
    }

    public Cuenta (Persona p, double cantidad) throws Exception {
        this.persona = new Persona(p.getNombre(), p.getEdad(), p.getDni());
        this.setCantidad(cantidad);
    }

    // Setters

    protected void setCantidad (double cantidad) throws Exception {
        try {
            this.cantidad = cantidad; }
        catch (Exception e) {
            throw new Exception("No se ha podido asignar esa cantidad");
        }
    }

    // Getters

    public double getCantidad(){ return this.cantidad; }

    // Ingresar

    public void ingresar (double cantidadIngreso) throws Exception {
        if (cantidadIngreso > 0) {
            this.setCantidad (this.getCantidad()+cantidadIngreso);
        } else throw new Exception("Ingreso con cantidad negativa no permitido");
    }

    // Retirar

    public void retirar (double cantidadReintegro) throws Exception{
        this.setCantidad (this.getCantidad() - cantidadReintegro);
    }

    // Mostrar los datos

    public String mostrar(){
        return this.persona.mostrar() + "cantidad = " + this.getCantidad() + "€";
    }

}
