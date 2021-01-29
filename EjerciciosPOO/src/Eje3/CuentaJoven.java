package Eje3;

import Eje1.Persona;
import Eje2.Cuenta;

public class CuentaJoven extends Cuenta {

    /**
     * Vamos a definir ahora una “Cuenta Joven”, para ello vamos a crear una nueva clase
     * CuantaJoven que deriva de la anterior. Cuando se crea esta nueva clase, además del titular
     * y la cantidad se debe guardar una bonificación que estará expresada en tanto por
     * ciento.
     * Construye los siguientes métodos para la clase:
     * Un constructor. Los setters y getters para el nuevo atributo.
     * En esta ocasión los titulares de este tipo de cuenta tienen que ser mayor de edad.,
     * por lo tanto hay que crear un método esTitularValido() que devuelve verdadero si el titular es mayor de edad pero menor de 25
     * años y falso en caso contrario.
     * Además la retirada de dinero sólo se podrá hacer si el titular es válido.
     * El método mostrar() debe devolver el mensaje de “Cuenta Joven” y la bonificación
     * de la cuenta.
     * Piensa los métodos heredados de la clase madre que hay que reescribir.
     * @author  Antonio Caballero
     * @version 1.0
     */

    // Atributos

    private double bonificacion;

    // Constructores

    public CuentaJoven(Persona p) throws Exception {
        super(p);
        if (p.esMayorDeEdad()) {
            this.setBonificacion(0);
        } else {
            throw new Exception("El titular debe ser mayor de edad.");
        }
    }

    // Setters

    private void setBonificacion (double cantidad) throws Exception {
        try {
            this.bonificacion = cantidad;
        } catch (Exception e) {
            throw new Exception("No se ha podido asignar esa bonificación");
        }
    }

    // Getters

    public double getBonificacion() {
        return this.bonificacion;
    }

    // Comprobación Edad

    public boolean esTitularValido () {
        return this.persona.esMayorDeEdad() && (this.persona.getEdad() <= 25);
    }

    // Retirar junto a la comprobación de edad como requisito

    public void retirar (double cantidadReintegro) throws Exception{
        if (this.esTitularValido()) {
            this.setCantidad (this.getCantidad() - cantidadReintegro);
        } else {
            throw new Exception("Titular no válido.");
        }
    }

    // Mostrar los datos
    
    public String mostrar(){
        return "Cuenta Joven\nBonificación = " + this.getBonificacion() + "%";
    }

}
