import java.util.List;

public class Main {
    public static void main(String[] args) {
        Fabrica fabrica = new Fabrica();

        // Simulación de agregar máquinas
        fabrica.agregarMaquina(new Maquina("Maquina A", 500));
        fabrica.agregarMaquina(new Maquina("Maquina B", 250));
        fabrica.agregarMaquina(new Maquina("Maquina C", 250));
        fabrica.agregarMaquina(new Maquina("Maquina D", 100));
        fabrica.agregarMaquina(new Maquina("Maquina E", 400));


        int cantPiezasAProducir = 1000;
        List<Maquina> resultado = fabrica.backProduccion(cantPiezasAProducir);

        System.out.println("Mejor combinación de máquinas para producir " + cantPiezasAProducir + " maquinas:");
        for (Maquina m : resultado) {
            System.out.println(m);
        }
    }
}
