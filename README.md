# 💱 Conversor de Monedas en Java

Este es un proyecto de consola en Java que permite convertir entre distintas monedas usando la API [ExchangeRate-API](https://www.exchangerate-api.com/). El programa soporta múltiples monedas, muestra las tasas de cambio actuales y mantiene un historial de conversiones guardado en un archivo JSON.

---

## 🧰 Tecnologías utilizadas

- **Java 17+**
- **Gson** (para manejo de JSON)
- **HTTP Client (Java 11+)**
- API de tasas de cambio: [`ExchangeRate-API`](https://www.exchangerate-api.com/)

---

## 📦 Características

- ✅ Conversión entre más de 160 monedas usando tasas reales.
- ✅ Menú interactivo por consola.
- ✅ Verificación de monedas válidas contra la API.
- ✅ Historial de conversiones guardado automáticamente en `historial.json`.
- ✅ Opción de ver y borrar historial desde el menú.
- ✅ Estructura modular con clases bien organizadas.

---

## 📁 Estructura del proyecto

```

## 🛠️ Requisitos

- Java 11 o superior
- Archivo `.jar` de [Gson](https://github.com/google/gson) (por ejemplo: `gson-2.8.9.jar`)

---

## 🚀 Cómo compilar y ejecutar

### 1. Compila todos los archivos `.java`:

```bash
javac -cp gson-2.8.9.jar *.java
```

### 2. Ejecuta el programa:

```bash
java -cp .:gson-2.8.9.jar Principal
```

> En Windows, reemplaza `:` por `;` en la clasepath: `-cp .;gson-2.8.9.jar`

---

## 🧪 Ejemplo de uso

```text
Bienvenidos/as al Conversor de Monedas

**** Elige una opción: ****
1 - VES -> USD
2 - USD -> VES
...
7 - Hacer otra conversión.
8 - Mostrar historial de conversiones.
0 - Salir.

Ingresa el monto que vas a convertir:
100
100.00 USD equivale a 93.50 EUR
(Tasa de cambio: 0.9350)
```

---

## 📂 Archivo de historial (`historial.json`)

El historial se guarda automáticamente en un archivo llamado `historial.json`. Aquí se almacenan las conversiones realizadas, incluso después de cerrar el programa.

Ejemplo:

```json
[
  {
    "monedaBase": "USD",
    "monedaDestino": "EUR",
    "cantidad": 100.0,
    "resultado": 93.5,
    "tasa": 0.935
  }
]
```

---

## 📷 Simulación de consola (como en IntelliJ IDEA)

```
📜 Historial de Conversiones:
 • 100.00 USD equivale a 93.50 EUR
   (Tasa de cambio: 0.9350)
 • 50.00 BRL equivale a 10.25 USD
   (Tasa de cambio: 0.2050)
```

---

## 📌 Notas

- Este proyecto es ideal para principiantes que desean practicar:
    - Manejo de API REST
    - Programación orientada a objetos
    - Lectura/escritura de archivos JSON
    - Consola interactiva en Java

---

## 📄 Licencia

Este proyecto se ofrece bajo la licencia MIT. Puedes usarlo, modificarlo y compartirlo libremente.

---

## ✨ Autor

**Michael Ziliani**  
Proyecto educativo de Alura Latam en Java · 2025
