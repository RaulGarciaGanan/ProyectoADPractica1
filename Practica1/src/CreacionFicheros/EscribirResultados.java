package CreacionFicheros;

import java.io.*;

public class EscribirResultados {
    public void escribirResultados(int[][] resultados) {

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("equipos.dat"))) {

            out.writeObject(resultados);

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
