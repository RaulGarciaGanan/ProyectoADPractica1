package CreacionFicheros;

import Clases.*;
import java.io.*;
import java.util.*;

public class LeerPartidos {
    public List<Partido> leerPartidos() throws ClassNotFoundException, IOException {
        ObjectInputStream fon = new ObjectInputStream(new FileInputStream("partidos.dat"));
        List<Partido> partidos = new ArrayList<Partido>();
        try {
            while (true) {
                partidos.add((Partido) fon.readObject());
            }
        } finally {
            return partidos;
        }
    }
}
