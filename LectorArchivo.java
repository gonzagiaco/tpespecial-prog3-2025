import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LectorArchivo {

    public static int cargarFabricaDesdeArchivo(String rutaArchivo, Fabrica fabrica) {
        int piezasTotales = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            boolean primeraLinea = true;

            while ((linea = br.readLine()) != null) {
                if (primeraLinea) {
                    piezasTotales = Integer.parseInt(linea.trim());
                    primeraLinea = false;
                } else {
                    String[] partes = linea.split(",");
                    if (partes.length == 2) {
                        String nombre = partes[0].trim();
                        int piezas = Integer.parseInt(partes[1].trim());
                        fabrica.agregarMaquina(new Maquina(nombre, piezas));
                    }
                }
            }

        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }

        return piezasTotales;
    }
}
