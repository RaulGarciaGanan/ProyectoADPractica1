import Clases.*;
import CreacionFicheros.*;
import XML.EscribirResultadoXML;


import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.*;

public class Futbol {
    int resultados[][];

    List<Equipo> equipos;
    EscribirEquipos escribirEquipos;
    EscribirPartidos escribirPartidos;
    LeerEquipos leerEquipos;
    LeerPartidos leerPartidos;
    EscribirResultados escribirResultados;
    LeerResultados leerResultados;
    List<Partido> partidos;
    ArrayList<Equipo> nombreEquipos;

    EscribirResultadoXML resultadoXML;

    Futbol() throws IOException {
        equipos = new ArrayList<Equipo>();
        resultados = new int[20][3];
        partidos = new ArrayList<Partido>();
        escribirEquipos = new EscribirEquipos();
        escribirPartidos = new EscribirPartidos();
        escribirResultados = new EscribirResultados();
        leerEquipos = new LeerEquipos();
        leerPartidos = new LeerPartidos();
        escribirResultados = new EscribirResultados();
        leerResultados = new LeerResultados();
        resultadoXML = new EscribirResultadoXML();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException, ParserConfigurationException, TransformerException {
        Futbol programa = new Futbol();
        programa.probar();

    }

    private void probar() throws ClassNotFoundException, IOException, ParserConfigurationException, TransformerException {
        inicializar();
        escribirEquipos.escribirEquipos(nombreEquipos);
        equipos = leerEquipos.leerEquipos();
        escribirPartidos.crearPartidos(equipos);
        partidos = leerPartidos.leerPartidos();
        llenarTablaResultados();
        escribirResultados.escribirResultados(resultados);
        resultados = leerResultados.leerResultados();
        imprimirGanadores(determinarGanador());
        resultadoXML.EscribirResultadoXML(resultados);
    }

    private void inicializar() {
        nombreEquipos = new ArrayList<Equipo>();
        nombreEquipos.add(new Equipo(1, "Madrid"));
        nombreEquipos.add(new Equipo(2, "Barcelona"));
        nombreEquipos.add(new Equipo(3, "Alaves"));
        nombreEquipos.add(new Equipo(4, "Athletic"));
        nombreEquipos.add(new Equipo(5, "Athletico"));
        nombreEquipos.add(new Equipo(6, "Real Sociedad"));
        nombreEquipos.add(new Equipo(7, "Sevilla"));
        nombreEquipos.add(new Equipo(8, "Vetis"));
        nombreEquipos.add(new Equipo(9, "Villareal"));
        nombreEquipos.add(new Equipo(10, "Rayo"));
        nombreEquipos.add(new Equipo(11, "Celta De Vigo"));
        nombreEquipos.add(new Equipo(12, "Levante"));
        nombreEquipos.add(new Equipo(13, "Granada"));
        nombreEquipos.add(new Equipo(14, "Valencia"));
        nombreEquipos.add(new Equipo(15, "Espanyol"));
        nombreEquipos.add(new Equipo(16, "Almeria"));
        nombreEquipos.add(new Equipo(17, "Elche"));
        nombreEquipos.add(new Equipo(18, "Getafe"));
        nombreEquipos.add(new Equipo(19, "Girona"));
        nombreEquipos.add(new Equipo(20, "Mallorca"));
    }

    private List<Integer> determinarGanador() {
        int maxPuntos = 0;
        for (int i = 0; i < 20; i++) {
            if (resultados[i][0] > maxPuntos) {
                maxPuntos = resultados[i][0];
            }
        }

        List<Integer> posiblesGanadores = new ArrayList<Integer>();
        for (int i = 0; i < 20; i++) {
            if (resultados[i][0] == maxPuntos) {
                posiblesGanadores.add(i + 1);
            }
        }
        return posiblesGanadores;
    }

    private void imprimirGanadores(List<Integer> posiblesGanadores) {
        for (int i = 0; i < equipos.size(); i++) {
            System.out
                    .println(equipos.get(i) + " ,Puntos: " + resultados[i][0] + " ,Goles a Favor: " + resultados[i][1] + " ,Goles en Contra: " + resultados[i][2]);
        }

        for (int i = 0; i < posiblesGanadores.size(); i++) {
            for (int j = 0; j < equipos.size(); j++) {

                if (equipos.get(j).getCodigo() == posiblesGanadores.get(i)) {
                    System.out.println("el/los ganador(es): " + equipos.get(j));
                }
            }
        }
    }

    private void llenarTablaResultados() {
        for (int i = 0; i < 20; i++) {
            int golAf = 0, golEc = 0, puntos = 0;
            for (int j = 0; j < partidos.size(); j++) {
                if (partidos.get(j).getCodEquipo1() == equipos.get(i).getCodigo()) {
                    golAf += partidos.get(j).getGoles1();
                    golEc += partidos.get(j).getGoles2();
                    puntos += determiarGanador(partidos.get(j).getGoles1(), partidos.get(j).getGoles2());
                }
                if (partidos.get(j).getCodEquipo2() == equipos.get(i).getCodigo()) {
                    golAf += partidos.get(j).getGoles2();
                    golEc += partidos.get(j).getGoles1();
                    puntos += determiarGanador(partidos.get(j).getGoles2(), partidos.get(j).getGoles1());
                }
            }
            resultados[i][0] = puntos;
            resultados[i][1] = golAf;
            resultados[i][2] = golEc;
        }
    }

    private int determiarGanador(int goles1, int goles2) {
        if (goles1 == goles2) {
            return 1;
        }
        if (goles1 > goles2) {
            return 3;
        }
        return 0;
    }
}