# Simulador de Supermercado con Hilos

Este proyecto simula el proceso de compra en un supermercado utilizando múltiples cajeras que procesan las compras de los clientes en hilos separados. La simulación incluye productos, clientes y cajeras, cada una procesando la compra de un cliente en paralelo.

## Estructura del Proyecto

El proyecto está organizado en los siguientes paquetes:

- `com.iudigital.simulador.supermercado.iud.app.domain`: Contiene las clases de dominio `ClienteProducto` y `Producto`.
- `conHilos`: Contiene las clases relacionadas con el procesamiento en hilos (`CajeraProductoHilos` y `CajeraProductoMainHilos`).

## Clases Principales

### Producto
```java
package com.iudigital.simulador.supermercado.iud.app.domain;

public class Producto {
    private String nombre;
    private float precio;
    private int cantidad;

    public Producto(String nombre, float precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    // Getters y setters
}

### ClienteProducto

package com.iudigital.simulador.supermercado.iud.app.domain;

import java.util.List;

public class ClienteProducto {
    private final String nombre;
    private final List<Producto> productos;

    public ClienteProducto(String nombre, List<Producto> productos) {
        this.nombre = nombre;
        this.productos = productos;
    }

    // Getters
}

### CajeraProductoHilos

package conHilos;

import com.iudigital.simulador.supermercado.iud.app.domain.ClienteProducto;
import com.iudigital.simulador.supermercado.iud.app.domain.Producto;

public class CajeraProductoHilos implements Runnable {
    private String nombre;
    private ClienteProducto cliente;
    private long timeStamp;
    private String identificador;

    public CajeraProductoHilos(String nombre, ClienteProducto cliente, long timeStamp, String identificador) {
        this.nombre = nombre;
        this.cliente = cliente;
        this.timeStamp = timeStamp;
        this.identificador = identificador;
    }

    @Override
    public void run() {
        this.procesarCompra(this.cliente, this.timeStamp);
    }

    public void procesarCompra(ClienteProducto cliente, long timeStamp) {
        // Implementación del procesamiento
    }

    private void esperarXSegundos() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("El hilo fue interrumpido: " + e.getMessage());
        }
    }
}

### CajeraProductoMainHilos

package conHilos;

import com.iudigital.simulador.supermercado.iud.app.domain.ClienteProducto;
import com.iudigital.simulador.supermercado.iud.app.domain.Producto;
import java.util.ArrayList;
import java.util.List;
import org.fusesource.jansi.AnsiConsole;

public class CajeraProductoMainHilos {
    public static void main(String[] args) {
        AnsiConsole.systemInstall();
        List<Producto> productos = new ArrayList<>();
        setProductos(productos);

        ClienteProducto cliente1 = new ClienteProducto("Francisco", productos);
        ClienteProducto cliente2 = new ClienteProducto("Pablo", productos);
        ClienteProducto cliente3 = new ClienteProducto("Juan", productos);

        long initialTime = System.currentTimeMillis();

        CajeraProductoHilos cajera1 = new CajeraProductoHilos("Valentina", cliente1, initialTime, "+++");
        CajeraProductoHilos cajera2 = new CajeraProductoHilos("Patricia", cliente2, initialTime, "===");
        CajeraProductoHilos cajera3 = new CajeraProductoHilos("Peranita", cliente3, initialTime, "^^^");

        Thread hilo1 = new Thread(cajera1);
        Thread hilo2 = new Thread(cajera2);
        Thread hilo3 = new Thread(cajera3);

        hilo1.start();
        hilo2.start();
        hilo3.start();
        
        AnsiConsole.systemUninstall();
    }

    private static void setProductos(List<Producto> productos) {
        Producto producto1 = new Producto("teclado", 50, 6);
        Producto producto2 = new Producto("mouse", 40, 10);
        Producto producto3 = new Producto("monitor", 200, 5);

        productos.add(producto1);
        productos.add(producto2);
        productos.add(producto3);
    }
}

### Instalación

Para clonar y ejecutar este proyecto necesitarás Git y Java JDK instalados en tu sistema.

# Clona el repositorio
git clone https://github.com/tu-usuario/simulador-supermercado.git
# Entra en el directorio del proyecto
cd simulador-supermercado
# Compila el proyecto
javac -d bin -sourcepath src src/conHilos/CajeraProductoMainHilos.java
# Ejecuta el proyecto
java -cp bin conHilos.CajeraProductoMainHilos

Uso
La aplicación crea una lista de productos.
Tres clientes son creados con la misma lista de productos.
Tres cajeras son creadas, cada una procesando la compra de un cliente en paralelo.
La salida muestra el progreso de cada cajera mientras procesan los productos de los clientes.
Tiene dos opciones de ejecucion sin hilos o con hilos.
Para simular el proceso sin hilos, ejecuta el archivo CajeraProductosMain.java
Para simular el proceso con hilos, ejecuta el archivo CajeraProductosMainHilos.java
