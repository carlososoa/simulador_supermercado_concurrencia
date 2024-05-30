package snthread;

import com.iudigital.simulador.supermercado.iud.app.domain.ClienteProducto;
import com.iudigital.simulador.supermercado.iud.app.domain.Producto;
import java.util.ArrayList;
import java.util.List;

/**
 * La clase principal CajeraProductoMain simula el procesamiento de compras por varias cajeras.
 * Crea una lista de productos, asigna clientes a las cajeras y simula el procesamiento de sus compras.
 * 
 * @autor Andri
 */
public class CajeraProductoMain {
    
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
        
        // Crear cajeras
        CajeraProducto cajera1 = new CajeraProducto("Valentina");
        CajeraProducto cajera2 = new CajeraProducto("Patricia");
        CajeraProducto cajera3 = new CajeraProducto("Peranita");
        
        // Procesar compras de los clientes por cada cajera
        cajera1.procesarCompra(cliente1, initialTime);
        cajera2.procesarCompra(cliente2, initialTime);
        cajera3.procesarCompra(cliente3, initialTime);
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
