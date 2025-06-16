import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Fabrica {
    private List<Maquina> maquinas;

    private int cantEstadosBack;
    private int cantCandidatosConsiderados;


    public Fabrica() {
        this.maquinas = new ArrayList<>();
        this.cantEstadosBack = 0;
        this.cantCandidatosConsiderados = 0;
    }

    public void agregarMaquina(Maquina maquina) {
        maquinas.add(maquina);
    }

    //cantPiezasProducir viene por main
    public List<Maquina> backProduccion(int cantPiezasProducir) {
        List<Maquina> resultado = new ArrayList<>();
        this.cantEstadosBack = 0;
        backProduccion(0, cantPiezasProducir, 0, new ArrayList<Maquina>(), resultado);

        return resultado;
    }

    public int getCantMaquinasEnFuncionamiento(List<Maquina> resultado){
        return resultado.size();
    }

    public int getCantCandidatosConsiderados() {
        return cantCandidatosConsiderados;
    }

    public int getCantEstadosBack() {
        return cantEstadosBack;
    }

    public int getCantPiezasProducidas(List<Maquina> resultado) {
        int cantPiezasProducidas = 0;
        for(Maquina maquina : resultado) {
            cantPiezasProducidas += maquina.getCantPiezas();
        }

        return cantPiezasProducidas;
    }

    /*
        ESTRATEGIA BACKTRACKING
        El árbol de exploración se va generando a partir de la combinación de las máquinas entre sí. El nodo sería una combinación actual de las máquinas seleccionadas.
        Estado final: Combinación de máquinas que producen exactamente la cantidad de piezas a producir.
        Estado solución: Combinación de máquinas que producen la cantidad exacta de piezas a producir, con la menor cantidad de máquinas en funcionamiento posible.
        Posibles podas: Se poda sí la cantidad de piezas actuales superan las cantidad de piezas a producir. Se poda si la combinación de máquinas actuales posee más máquinas que el mejorResultado.

     */

    private void backProduccion(int i, int cantPiezasProducir, int cantPiezasActual, List<Maquina> resultadoActual, List<Maquina> mejorResultado) {
        cantEstadosBack++;
        if (cantPiezasActual == cantPiezasProducir) {
            if (mejorResultado.isEmpty() || resultadoActual.size() < mejorResultado.size()) {
                mejorResultado.clear();
                mejorResultado.addAll(resultadoActual);
            }
            } else if ((cantPiezasActual < cantPiezasProducir) &&  (mejorResultado.isEmpty() || resultadoActual.size() < mejorResultado.size())){ //poda

                    for (int j = i; j < maquinas.size(); j++) {
                        Maquina m = maquinas.get(j);
                        resultadoActual.add(m);
                        backProduccion(j, cantPiezasProducir, cantPiezasActual + m.getCantPiezas(), resultadoActual, mejorResultado);
                        resultadoActual.remove(resultadoActual.size() - 1);

                }

            }
        }

        /*GREEDY*/

        /* ESTRATEGIA GREEDY
        Candidatos: Máquinas disponibles agregadas por el lector de archivos

        La estrategia greedy que elegimos fue la siguiente:
        Ordenar la lista de candidatos (máquinas) por cantidad de piezas que producen las mismas, de mayor a menor.
        Considerar el candidato, y si es factible añadirlo al arreglo solución, sino, removerlo de la lista de candidatos.
        Es factible si: La suma total de piezas del resultado, más la cantidad de piezas que produce la máquina candidata, es menor o igual a la cantidad de piezas a producir.
        Vamos iterando por medio de un while hasta que sucedan dos cosas: O se vacía la lista de candidatos, o llegamos a una solución (producimos el total de piezas).
        * */

        public List<Maquina> greedyProduccion(int cantPiezasProducir) {
            List<Maquina> resultado = new ArrayList<>();
            this.cantCandidatosConsiderados = 0;
            greedyProduccion(resultado, maquinas, cantPiezasProducir);


            return resultado;
        }

        private void greedyProduccion(List<Maquina> resultado, List<Maquina> maquinasCandidatas, int cantPiezasProducir) {
            Collections.sort(maquinasCandidatas);
            int cantPiezasActual = 0;

            while(!maquinasCandidatas.isEmpty() && !esSolucion(cantPiezasActual, cantPiezasProducir)){

                Maquina tmp = maquinasCandidatas.get(0);
                cantCandidatosConsiderados++;

                if(factibleGreedy(cantPiezasActual, cantPiezasProducir, tmp)){
                    resultado.add(tmp);
                    cantPiezasActual += tmp.getCantPiezas();
                }else{
                    maquinasCandidatas.remove(0);
                }
            }
        }

        private boolean esSolucion(int cantPiezasActual, int cantPiezasProducir){
            return cantPiezasActual == cantPiezasProducir;
        }

        private boolean factibleGreedy(int cantPiezasActual, int cantPiezasProducir, Maquina tmp){
            return cantPiezasActual + tmp.getCantPiezas() <= cantPiezasProducir;
        }

    }

