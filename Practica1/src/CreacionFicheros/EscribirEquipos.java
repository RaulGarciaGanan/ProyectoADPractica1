package CreacionFicheros;

import Clases.Equipo;
import java.io.*;
import java.util.ArrayList;

public class EscribirEquipos {

    public EscribirEquipos() {
        // TODO Auto-generated constructor stub
    }
    public static void escribirEquipos(ArrayList<Equipo> array) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream("nombres.dat"))) {
            for (int i = 0; i < 20; i++) {
                out.writeObject(array.get(i).getNombre());
            }

        }
    }
}
