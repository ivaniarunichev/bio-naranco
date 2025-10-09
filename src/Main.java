import java.io.*;
import java.util.HashMap;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        LabData labdata  = new LabData();
        try {
            //labdata.leerPacientes();
            labdata.leerTecnicos();
            labdata.leerMuestras();
            //labdata.generarMuestrasConsolidado();
            //labdata.generarMuestrasAppExterna();
            //labdata.generarSerializado();

            System.out.println("Se ha guardado correctamente");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}