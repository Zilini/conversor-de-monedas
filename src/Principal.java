import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ConsultarTasa consulta = new ConsultarTasa();
        ComprobarMonedas comprobar = new ComprobarMonedas();
        HistorialDeCambios historial = new HistorialDeCambios();

        while (true) {
            System.out.println("\n*****************************************\n");
            System.out.println("Bienvenodos/as al Conversor de Monedas\n");
            System.out.println("""
                                    **** Elige una opción: ****
                    1 - Bolivares Soberanos Venezolanos(VES)    ->   Dolar Estadounidense(USD).
                    2 - Dolar Estadounidense(USD)               ->   Bolivares Soberanos Venezolanos(VES).
                    3 - Peso Colombiano(COP)                    ->   Dolar Estadounidense(USD).
                    4 - Dolar Estadounidense(USD)               ->   Peso Colombiano(COP).
                    5 - Real Brasileño(BRL)                     ->   Dolar Estadounidense(USD).
                    6 - Dolar Estadounidense(USD)               ->   Real Brasileño(BRL).
                    
                    7 - Hacer otra conversión.
                    8 - Mostrar historial de conversiones.
                    
                        Escriba cero (0) o escribe salir (SALIR) para finalizar el programa.
                    """);

            String opcion = teclado.next();

            if (opcion.equals("0") || opcion.toUpperCase().equals("SALIR")) {
                System.out.println("Gracias por visitar el conversor de monedas.\n" +
                        "¡Hasta pronto!\n" +
                        "Cerrando conversor...");
                return;
            }


            String monedaBase = "", monedaDestino = "";

            switch (opcion) {
                case "1" -> {
                    System.out.println("""
                                                  **   Nota   **
                                El Bolivar Soberano experimenta una mayor volatilidad
                            debido a las diferencias entre el tipo de cambio de
                            diferentes mercados y el tipo de cambio oficial. En este
                            caso se aplicarán el tipo de cambio publicado por el
                            banco central correspondiente. Los resultados mostrados
                            en nuestro conversor podrían ser diferentes al de otras
                            fuentes.
                            """);
                    monedaBase = "VES";
                    monedaDestino = "USD";
                }
                case "2" -> {
                    System.out.println("""
                                                  **   Nota   **
                                El Bolivar Soberano experimenta una mayor volatilidad
                            debido a las diferencias entre el tipo de cambio de
                            diferentes mercados y el tipo de cambio oficial. En este
                            caso se aplicarán el tipo de cambio publicado por el
                            banco central correspondiente. Los resultados mostrados
                            en nuestro conversor podrían ser diferentes al de otras
                            fuentes.
                            """);
                    monedaBase = "USD";
                    monedaDestino = "VES";}
                case "3" -> {monedaBase = "COP"; monedaDestino = "USD";}
                case "4" -> {monedaBase = "USD"; monedaDestino = "COP";}
                case "5" -> {monedaBase = "BRL"; monedaDestino = "USD";}
                case "6" -> {monedaBase = "USD"; monedaDestino = "BRL";}
                case "7" -> {
                    System.out.println("Ingresa la moneda que vas a convertir (ej: USD, BRL...):");
                    monedaBase = teclado.next().trim().toUpperCase();

                    if (!comprobar.aprobada(monedaBase)) {
                        System.out.println("Moneda no válida. Intentalo de nuevo por favor.");

                        System.out.println("¿Quieres ver las monedas disponibles?. Responde SI o NO");
                        String respuesta = teclado.next().trim().toUpperCase();

                        if (respuesta.equalsIgnoreCase("SI")) {
                            MonedaYPais.mostrarMonedasConPaises(MonedaYPais.monedasConPais());
                        } else {
                            System.out.println("Respuesta inválida. Intentalo de nuevo por favor.");
                        }
                        continue;
                    }

                    System.out.println("Ingresa la moneda a la que deseas convertir (ej: USD, BRL...)");
                    monedaDestino = teclado.next().trim().toUpperCase();

                    if (!comprobar.aprobada(monedaDestino)) {
                        System.out.println("Moneda no válida. Intentalo de nuevo por favor.");

                        System.out.println("¿Quieres ver las monedas disonibles?. Responde SI o NO");
                        String respuesta = teclado.next().trim().toUpperCase();

                        if (respuesta.equalsIgnoreCase("SI")) {
                            MonedaYPais.mostrarMonedasConPaises(MonedaYPais.monedasConPais());
                        } else {
                            System.out.println("Respuesta inválida. Intentalo de nuevo por favor.");
                        }
                        continue;
                    }
                }
                case "8" -> {
                    historial.verHistorial();

                    if (!historial.vacio()) {
                        System.out.println("¿Quieres borrar el historial? (SI/NO)");
                        String resp = teclado.next().trim().toUpperCase();
                        if (resp.equals("SI")) {
                            historial.vaciarHistorial();
                        } else {
                            System.out.println("El historial se ha mantenido");
                        }
                    }
                    continue;
                }
                default -> {
                        System.out.println("Opción inválida. Intentalo de nuevo por favor.");
                        continue;
                }
            }

            System.out.println("Ingresa el monto que vas a convertir.");
            double cantidad;

            try {
                cantidad = Double.parseDouble(teclado.next().trim());
            } catch (NumberFormatException e) {
                System.out.println("El monto ingresado no es válido. " +
                        " Intenta de nuevo por favor.\n");
                continue;
            }

            try {
                Tasa resultado = consulta.buscarTasa(monedaBase, monedaDestino, cantidad);
                System.out.println(resultado);
            } catch (Exception e) {
                System.out.println("Error inesperado: " + e.getMessage());
            }
        }
    }
}
