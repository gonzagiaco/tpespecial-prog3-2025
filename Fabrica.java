import java.util.ArrayList;
import java.util.List;

public class Fabrica {
    private List<Maquina> maquinas = new ArrayList<>();
    private int mejorCamino;
    private int cantEstadosBack = 0;


    public void agregarMaquina(Maquina maquina) {
        maquinas.add(maquina);
    }

    //cantPiezasProducir viene por main
    public List<Maquina> backProduccion(int cantPiezasProducir) {
        List<Maquina> resultado = new ArrayList<>();
        backProduccion(0, cantPiezasProducir, 0, new ArrayList<Maquina>(), resultado);
        System.out.println("Cantidad de estados generados: " + cantEstadosBack);
        return resultado;
    }

    private void backProduccion(int i, int cantPiezasProducir, int cantPiezasActual, List<Maquina> resultadoActual, List<Maquina> mejorResultado) {
        //if(cantPiezasActual == cantPiezasProducir) SIGNIFICA QUE PRODUCIMOS TODAS LAS PIEZAS{
        cantEstadosBack++;
        if (cantPiezasActual == cantPiezasProducir) {
            if (mejorResultado.isEmpty() || resultadoActual.size() < mejorResultado.size()) {
                mejorResultado.clear();
                mejorResultado.addAll(resultadoActual);
            }
            } else {
                if ((cantPiezasActual < cantPiezasProducir) || (resultadoActual.size() < mejorResultado.size())) {

                    for (int j = i; j < maquinas.size(); j++) {
                        Maquina m = maquinas.get(j);
                        resultadoActual.add(m);
                        backProduccion(j, cantPiezasProducir, cantPiezasActual + m.getCantPiezas(), resultadoActual, mejorResultado);
                        resultadoActual.remove(resultadoActual.size() - 1);
                    }

                }

            }
            // mejorResultado.clear() BORRAMOS TODO DEL RESULTADO
            // mejorResultado.addAll(maquinasActual) // REEMPLAZAMOS EL MEJOR RESULTADO
            //} else {
            //Poda puede ser: cantPiezasActual tiene que ser menor a cantPiezasProducir y
            //resultadoActual.size() es mayor a mejorResultado.size(), al pedingui
        }

    }

