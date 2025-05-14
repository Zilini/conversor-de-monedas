import java.util.ArrayList;
import java.util.List;

public class HistorialConversiones {
    private final List<Tasa> historial = new ArrayList<>();

    public void agregarConversion(Tasa conversion) {
        historial.add(conversion);
    }

    public void mostrarHistorial() {
        if (historial.isEmpty()) {
            System.out.println("📭 No hay conversiones en el historial.");
            return;
        }

        System.out.println("\n📜 Historial de Conversiones:");
        for (Tasa conversion : historial) {
            System.out.println(" • " + conversion);
        }
    }

    public void limpiarHistorial() {
        historial.clear();
        System.out.println("✅ Historial borrado correctamente.");
    }

    public boolean estaVacio() {
        return historial.isEmpty();
    }
}
