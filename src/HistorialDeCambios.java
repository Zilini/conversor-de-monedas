import java.util.ArrayList;
import java.util.List;

public class HistorialDeCambios {
    private List<Tasa> historial = new ArrayList<>();

    public void agregarCambio (Tasa cambio) {
        historial.add(cambio);
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
    }

    public boolean vacio () {
        return historial.isEmpty();
    }
}
