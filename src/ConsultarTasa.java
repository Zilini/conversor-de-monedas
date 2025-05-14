import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultarTasa {

    public Tasa buscarTasa (String monedaBase, String monedaDestino, double cantidad) {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/67a4e9a12b1b6a076c72c679/latest/" + monedaBase);

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(direccion)
                    .GET()
                    .build();

            HttpResponse <String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            JsonObject json = JsonParser.parseString(response.body()).getAsJsonObject();
            JsonObject rates = json.getAsJsonObject("conversion_rates");

            double tasa = rates.get(monedaDestino).getAsDouble();
            double resultado = cantidad * tasa;
            return new Tasa (monedaBase, monedaDestino, cantidad, resultado, tasa);
        } catch (Exception e) {
            throw new RuntimeException("Error al encontrar la tasa de cambio: " + e.getMessage(), e);
        }
    }
}
