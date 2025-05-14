public record Tasa (String monedaBase,
                   String monedaDestino,
                   double cantidad,
                   double resultado,
                   double tasa) {

    @Override
    public String toString () {
        return String.format("%.2f %s equivale a %.2f %s%n(Tasa de cambio: %.4f)",
                cantidad,
                monedaBase,
                resultado,
                monedaDestino,
                tasa);
    }
}
