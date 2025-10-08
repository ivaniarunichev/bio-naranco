import java.io.*;
import java.util.HashMap;

class LabData implements Serializable {
    //private HashMap<...> pacientes;
    private HashMap<String, Tecnico> tecnicos = new HashMap<>();
    //    private List<...> muestras;

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
                String[] parts = linea.split("\\t");
                if (parts.length == 4)
                    tecnicos.put(parts[0], new Tecnico(parts[0], parts[1], parts[2], parts[3]));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


        /*
        public ...

        leerMuestras() {

        }


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