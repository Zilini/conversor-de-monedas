import java.util.ArrayList;
import java.util.List;

public class HistorialDeCambios {
    private List<Tasa> historial = new ArrayList<>();
    private CreaArchivoHistorial json = new CreaArchivoHistorial();

    public void agregarCambio (Tasa cambio) {
        historial.add(cambio);
    }

    public void agregarConversion (Tasa conversion) {
        historial.add(conversion);
        json.guardarHistorial(historial);
    }

    public void verHistorial () {
        if (historial.isEmpty()) {
            System.out.println("Aún no se ha realizado ninguna conversión.");
            return;
        }

        System.out.println("\nConversiones realizadas:");
        for (Tasa cambio : historial) {
            System.out.println(" • " + cambio);
        }
    }

    public  void vaciarHistorial () {
        historial.clear();
        System.out.println("Historial vaciado correctamente");
        json.guardarHistorial(historial);
    }

    public boolean vacio () {
        return historial.isEmpty();
    }
}
