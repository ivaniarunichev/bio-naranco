import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class LabData implements Serializable {
    //private HashMap<...> pacientes;
    private HashMap<String, Tecnico> tecnicos = new HashMap<>();
    private List<Muestra> muestras = new ArrayList<>();

        /* Carga los datos en los arrays leyendo los ficheros de entrada en ./data/in
        public ...

        leerPacientes() {

        }
        */

    public void leerTecnicos() throws IOException {
        try {
            BufferedReader br = new BufferedReader(new FileReader("data/in/tecnicos.tsv"));

            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.startsWith("#") || linea.trim().isEmpty()) continue;
                String[] parte = linea.split("\\t");
                if (parte.length == 4)
                    tecnicos.put(parte[0], new Tecnico(parte[0], parte[1], parte[2], parte[3]));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void leerMuestras() throws IOException {
        try {
            BufferedReader br = new BufferedReader(new FileReader("data/in/muestras.psv"));

            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.startsWith("#") || linea.trim().isEmpty()) continue;
                String[] parte = linea.split("\\t");
                if (parte.length == 6)
                    muestras.add(new Muestra(parte[0], parte[1], parte[2], parte[3], parte[4], Integer.parseInt(parte[5])));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

        /*
         * Escribe los datos generando los ficheros de salida en ./data/out


        public void generarMuestrasConsolidado() {

        }

        public void generarMuestrasAppExterna() {

        }

        public void generarSerializado() {

        }
    }
    */
}