package CreacionFicheros;

import Clases.*;


import java.io.*;

import java.util.*;


public class EscribirPartidos {
    public void crearPartidos(List<Equipo> equipos) throws IOException {

        Random goles = new Random();
        ArrayList<Partido> partidos = new ArrayList<Partido>();
        for (int i = 0; i < equipos.size(); i++) {
            for (int j = 0; j < equipos.size(); j++) {
                if (equipos.get(i).getCodigo() != equipos.get(j).getCodigo()) {
                    partidos.add(new Partido(equipos.get(i).getCodigo(), equipos.get(j).getCodigo(), goles.nextInt(10),
                            goles.nextInt(10)));
                }
            }
        }

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("partidos.dat"))) {
            for (int i = 0; i < partidos.size(); i++) {
                out.writeObject(partidos.get(i));
            }
        }
    }
}
