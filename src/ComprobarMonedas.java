import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Set;

public class ComprobarMonedas {
    private  Set<String> monedasDisponibles;

    public ComprobarMonedas() {
        this.monedasDisponibles = cargarMonedas();
    }

    private Set<String> cargarMonedas() {
        try {
            String url = "https://v6.exchangerate-api.com/v6/67a4e9a12b1b6a076c72c679/latest/USD";

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            JsonObject json = JsonParser.parseString(response.body()).getAsJsonObject();
            JsonObject rates = json.getAsJsonObject("conversion_rates");

            return rates.keySet(); // retorna los códigos válidos como Set<String>
        } catch (Exception e) {
            throw new RuntimeException("No se pudieron comprobar las monedas disponibles.", e);
        }
    }

    public  void mostrarMonedasConPais () {
       MonedaYPais.mostrarMonedasConPaises(monedasDisponibles);
    }

    public boolean aprobada(String codigoMoneda) {
        return monedasDisponibles.contains(codigoMoneda.toUpperCase());
    }

    public Set<String> getMonedasDisponibles() {
        return monedasDisponibles;
    }
}
