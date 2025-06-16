public class Maquina implements Comparable<Maquina> {

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

    public int compareTo(Maquina otra){
        return Integer.compare(otra.getCantPiezas(), this.getCantPiezas());
    }

    @Override
    public String toString() {
        return "Maquina{" +
                "nombre='" + nombre + '\'' +
                ", cantPiezas=" + cantPiezas +
                '}';
    }
}
