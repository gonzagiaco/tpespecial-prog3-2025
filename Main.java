import java.util.List;

public class Main {
    public static void main(String[] args) {
        Fabrica fabrica = new Fabrica();

        int cantPiezasAProducir = LectorArchivo.cargarFabricaDesdeArchivo("maquinas.csv",fabrica);


        //BACKTRACKING

        List<Maquina> resultadoBacktracking = fabrica.backProduccion(cantPiezasAProducir);


        if(resultadoBacktracking.isEmpty()){
            System.out.println("No se encontró solución con backtracking");
        }else{
        System.out.println("Backtracking");
        System.out.println("Solución obtenida:");
        for (Maquina m : resultadoBacktracking) {
            System.out.println(m);
        }
        System.out.println("Solución obtenida: Cantidad piezas producidas:" + fabrica.getCantPiezasProducidas(resultadoBacktracking) + " Cantidad de puestas en funcionamiento: " + fabrica.getCantMaquinasEnFuncionamiento(resultadoBacktracking));
        System.out.println("Cantidad de estados generados: " + fabrica.getCantEstadosBack());
        }

        //GREEDY

        List<Maquina> resultadoGreedy = fabrica.greedyProduccion(cantPiezasAProducir);

        if(resultadoGreedy.isEmpty()){
            System.out.println("No se encontró solución con greedy");
        }else {
            System.out.println("Greedy");
            System.out.println("Solución obtenida:");
            for (Maquina m : resultadoGreedy) {
                System.out.println(m);
            }
            System.out.println("Solución obtenida: Cantidad piezas producidas:" + fabrica.getCantPiezasProducidas(resultadoGreedy) + " Cantidad de puestas en funcionamiento: " + fabrica.getCantMaquinasEnFuncionamiento(resultadoGreedy));
            System.out.println("Cantidad de candidatos considerados: " + fabrica.getCantCandidatosConsiderados());
        }
    }
}
