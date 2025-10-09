import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class LabData implements Serializable {
    private HashMap<String, Paciente> pacientes = new HashMap<>();
    private HashMap<String, Tecnico> tecnicos = new HashMap<>();
    private List<Muestra> muestras = new ArrayList<>();


        /* Carga los datos en los arrays leyendo los ficheros de entrada en ./data/in
        public ...*/

    public void leerPacientes() {

        try {
            BufferedReader br = new BufferedReader(new FileReader("./data/in/pacientes.csv"));

            String linea;

            while ((linea = br.readLine()) != null){
                if (linea.startsWith("#") || linea.trim().isEmpty())continue;
                String[] parte = linea.split(",");
                if (parte.length == 4){
                    pacientes.put(parte[0], new Paciente(parte[0], parte[1], parte[2], parte[3]));
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


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
                String[] parte = linea.split("\\|");
                if (parte.length == 6)
                    muestras.add(new Muestra(parte[0], parte[1], parte[2], parte[3], parte[4], Integer.parseInt(parte[5])));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

        /*
         * Escribe los datos generando los ficheros de salida en ./data/out*/



        public void generarMuestrasConsolidado() {
            try {

                File carpeta = new File("data/out");
                if (!carpeta.exists()) carpeta.mkdir();

                PrintWriter pw = new PrintWriter("data/out/muestras_consolidado.csv");
                pw.println("#idMuestra|idPaciente|idTecnico|tipo(Sangre/Orina/Saliva)|estado(Recepcionada/Procesada/Rechazada)|vol_ml");

                for (Muestra m : muestras){
                    Paciente p = pacientes.get(m.getIdPaciente());
                    Tecnico t = tecnicos.get(m.getIdTecnico());

                    if (p == null || t == null)continue;

                    pw.printf("%s,%s,%s,%s,%s,%s,%s,%.2fn",
                            m.getIdMuestra(),
                            p.getIdPaciente(),
                            p.getNombre(),
                            t.getIdTecnico(),
                            t.getNombre(),
                            m.getTipo(),
                            m.getEstado(),
                            m.getVol_ml());

                    pw.close();

                    System.out.println("Archivo crado en data/out");
                }


            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }

        }

        //Metodo crear ficheros binarios

/*
        public void generarMuestrasAppExterna() {

        }

        public void generarSerializado() {

        }
    }
    */
}