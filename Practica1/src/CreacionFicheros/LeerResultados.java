package CreacionFicheros;

import java.io.*;

public class LeerResultados {
    public LeerResultados() {
        // TODO Auto-generated constructor stub
    }
    public int[][] leerResultados() {
        int resultados[][] = null;

        try {
            ObjectInputStream fon = new ObjectInputStream(new FileInputStream("equipos.dat"));
            resultados= (int[][]) fon.readObject();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return resultados;
    }
}
