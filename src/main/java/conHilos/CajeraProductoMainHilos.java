package conHilos;

import com.iudigital.simulador.supermercado.iud.app.domain.ClienteProducto;
import com.iudigital.simulador.supermercado.iud.app.domain.Producto;
import java.util.ArrayList;
import java.util.List;

/**
 * La clase principal CajeraProductoMainHilos simula el procesamiento de compras por varias cajeras en hilos separados.
 * Utiliza la biblioteca Jansi para formatear la salida de la consola.
 * 
 * @autor Andri
 */
public class CajeraProductoMainHilos {
    
    public static void main(String[] args) {
       
        
        // Crear la lista de productos
        List<Producto> productos = new ArrayList<>();
        setProductos(productos);

        // Crear clientes con la lista de productos
        ClienteProducto cliente1 = new ClienteProducto("Francisco", productos);
        ClienteProducto cliente2 = new ClienteProducto("Pablo", productos);
        ClienteProducto cliente3 = new ClienteProducto("Juan", productos);

        // Tiempo inicial para el procesamiento
        long initialTime = System.currentTimeMillis();

        // Crear instancias de CajeraProductoHilos para cada cliente
        CajeraProductoHilos cajera1 = new CajeraProductoHilos("Valentina", cliente1, initialTime, "+++");
        CajeraProductoHilos cajera2 = new CajeraProductoHilos("Patricia", cliente2, initialTime, "===");
        CajeraProductoHilos cajera3 = new CajeraProductoHilos("Peranita", cliente3, initialTime, "^^^");

        // Crear y iniciar hilos para cada cajera
        Thread hilo1 = new Thread(cajera1);
        Thread hilo2 = new Thread(cajera2);
        Thread hilo3 = new Thread(cajera3);

        hilo1.start();
        hilo2.start();
        hilo3.start();       
    }

    /**
     * Método que inicializa la lista de productos.
     * 
     * @param productos La lista de productos a inicializar
     */
    private static void setProductos(List<Producto> productos) {
        Producto producto1 = new Producto("teclado", 50, 6);
        Producto producto2 = new Producto("mouse", 40, 10);
        Producto producto3 = new Producto("monitor", 200, 5);

        productos.add(producto1);
        productos.add(producto2);
        productos.add(producto3);
    }
}