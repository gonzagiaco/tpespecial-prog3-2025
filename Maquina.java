public class Maquina {

    private int cantPiezas;
    private String nombre;


    public Maquina(String nombre, int cantPiezas) {
        this.cantPiezas = cantPiezas;
        this.nombre = nombre;
    }

    public int getCantPiezas() {
        return cantPiezas;
    }

    public void setCantPiezas(int cantPiezas) {
        this.cantPiezas = cantPiezas;
    }

    @Override
    public String toString() {
        return "Maquina{" +
                "cantPiezas=" + cantPiezas +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
