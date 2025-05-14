import java.util.Map;
import java.util.Set;

public class MonedaYPais {
    private static Map<String, String> monedasConPaises = Map.ofEntries(
            Map.entry("USD", "Estados Unidos"),
            Map.entry("VES", "Venezuela"),
            Map.entry("COP", "Colombia"),
            Map.entry("PEN", "Perú"),
            Map.entry("ARS", "Argentina"),
            Map.entry("BRL", "Brasil"),
            Map.entry("EUR", "Unión Europea"),
            Map.entry("MXN", "México"),
            Map.entry("CLP", "Chile"),
            Map.entry("JPY", "Japón"),
            Map.entry("GBP", "Reino Unido"),
            Map.entry("CAD", "Canadá"),
            Map.entry("AUD", "Australia"),
            Map.entry("CHF", "Suiza"),
            Map.entry("CNY", "China"),
            Map.entry("INR", "India"),
            Map.entry("KRW", "Corea del Sur"),
            Map.entry("ZAR", "Sudáfrica"),
            Map.entry("RUB", "Rusia"),
            Map.entry("TRY", "Turquía"),
            Map.entry("SGD", "Singapur"),
            Map.entry("MYR", "Malasia"),
            Map.entry("THB", "Tailandia"),
            Map.entry("IDR", "Indonesia"),
            Map.entry("PHP", "Filipinas"),
            Map.entry("HKD", "Hong Kong"),
            Map.entry("SEK", "Suecia"),
            Map.entry("NOK", "Noruega"),
            Map.entry("DKK", "Dinamarca"),
            Map.entry("PLN", "Polonia"),
            Map.entry("HUF", "Hungría"),
            Map.entry("CZK", "República Checa"),
            Map.entry("ILS", "Israel"),
            Map.entry("KWD", "Kuwait"),
            Map.entry("BHD", "Bahréin"),
            Map.entry("QAR", "Catar"),
            Map.entry("SAR", "Arabia Saudita"),
            Map.entry("OMR", "Omán"),
            Map.entry("AED", "Emiratos Árabes Unidos"),
            Map.entry("EGP", "Egipto"),
            Map.entry("MAD", "Marruecos"),
            Map.entry("TND", "Túnez"),
            Map.entry("LKR", "Sri Lanka"),
            Map.entry("BDT", "Bangladesh"),
            Map.entry("PKR", "Pakistán"),
            Map.entry("AFN", "Afganistán"),
            Map.entry("BAM", "Bosnia y Herzegovina"),
            Map.entry("MKD", "Macedonia del Norte"),
            Map.entry("RSD", "Serbia"),
            Map.entry("BGN", "Bulgaria"),
            Map.entry("KZT", "Kazajistán"),
            Map.entry("UZS", "Uzbekistán"),
            Map.entry("AZN", "Azerbaiyán"),
            Map.entry("GEL", "Georgia"),
            Map.entry("AMD", "Armenia"),
            Map.entry("KHR", "Camboya"),
            Map.entry("LAK", "Laos")
    );

    public static void mostrarMonedasConPaises(Set<String> disponibles) {
        System.out.println("""
                ** A continuación se muestra una lista de algunas de nuestras
                monedas disponibles con sus países correspondientes. Si falta
                alguna moneda, puedes ingresar el código de la moneda manualmente
                (ej: USD, BRL), y verificar si está disponible **
                """);
        for (String codigo : disponibles) {
            String pais = monedasConPaises.getOrDefault(codigo, "País desconocido");
            System.out.println(" - " + codigo + " (" + pais + ")");
        }
    }

    public static Set<String> monedasConPais() {
        return monedasConPaises.keySet();
    }
}
