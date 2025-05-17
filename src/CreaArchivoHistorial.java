import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CreaArchivoHisyorial {

    private  String archivo = "historial.json";
    private Gson gson  = new GsonBuilder().setPrettyPrinting().create();

    public void guardarHistorial (List<Tasa> historial) {
        try (FileWriter escritura = new FileWriter(archivo)) {
            escritura.write(gson.toJson(historial));
        } catch (IOException e) {
            System.out.println("Error al guardar ek historial: " + e.getMessage());
        }
    }

    public List<Tasa> cargarHistorial() {
        try (FileReader lector = new FileReader(archivo)) {
            Tasa[] tasas = gson.fromJson(lector, Tasa[].class);

            if (tasas != null) {
                // Convertimos el arreglo en una lista y la devolvemos
                return new ArrayList<>(List.of(tasas));
            }
        } catch (IOException e) {
            // Si hay error al leer el archivo, devolvemos una lista vacía
        }

        return new ArrayList<>();
    }
}
