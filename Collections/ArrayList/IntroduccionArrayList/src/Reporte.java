public class Reporte {
    String ciudad;
    int casos;
    String fecha;

    public Reporte(String ciudad, int casos, String fecha) {
        this.ciudad = ciudad;
        this.casos = casos;
        this.fecha = fecha;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getCasos() {
        return casos;
    }

    public void setCasos(int casos) {
        this.casos = casos;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    // Reporgramas equals para crear la condición de comparación también puede cambiarle el nombre y que sea un metodo normal

    @Override
    public boolean equals(Object o) {
        Reporte reporte = (Reporte) o;
        return reporte.getCasos() == this.casos;
    }

    @Override
    public String toString() {
        return "Reporte{" +
                "ciudad='" + ciudad + '\'' +
                ", casos=" + casos +
                ", fecha='" + fecha + '\'' +
                '}';
    }
}