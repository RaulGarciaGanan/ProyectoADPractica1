package CreacionFicheros;

import Clases.*;
import java.io.*;
import java.util.*;

public class LeerEquipos {
    public String path = "nombres.dat";

    public LeerEquipos() throws IOException {
    }

    public List leerEquipos() throws IOException, ClassNotFoundException {
        ObjectInputStream fon = new ObjectInputStream(new FileInputStream(path));
        List<Equipo> equipos = new ArrayList<Equipo>();
        try {
            for (int i = 0; i < 20; i++) {
                equipos.add(new Equipo(i + 1, (String) fon.readObject()));
            }
        } finally {
            // TODO: handle finally clause
            return equipos;
        }
    }
}
