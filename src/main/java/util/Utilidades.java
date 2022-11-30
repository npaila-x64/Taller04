package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Utilidades {

    public static void main(String[] args) {
        try {
            String contenidosTxt = leerArchivo("src/main/datos/alineaciones/aus.txt");

            for (String fila : contenidosTxt.split("\\R")) {
                System.out.println(fila.split(";")[0]);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static String leerArchivo(String ruta) throws FileNotFoundException {
        StringBuilder st = new StringBuilder();
        File archivo = new File(ruta);
        try (Scanner scanner = new Scanner(archivo)) {
            while (scanner.hasNextLine()) {
                st.append(scanner.nextLine()).append("\n");
            }
        }
        return st.toString();
    }
}
