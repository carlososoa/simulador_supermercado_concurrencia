package snthread;

import com.iudigital.simulador.supermercado.iud.app.domain.ClienteProducto;
import com.iudigital.simulador.supermercado.iud.app.domain.Producto;

/**
 * La clase CajeraProducto simula el proceso de una cajera que procesa la compra de un cliente.
 * Incluye métodos para procesar la compra de productos y simular un retraso en el procesamiento.
 * 
 * @autor Andri
 */
public class CajeraProducto {

    // Nombre de la cajera
    private String nombre;

    /**
     * Constructor de la clase CajeraProducto.
     * 
     * @param nombre El nombre de la cajera
     */
    public CajeraProducto(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Procesa la compra de los productos de un cliente.
     * 
     * @param cliente El cliente cuyas compras serán procesadas
     * @param timeStamp El tiempo de inicio del procesamiento en milisegundos
     */
    public void procesarCompra(ClienteProducto cliente, long timeStamp) {
        long tiempoInicio = (System.currentTimeMillis() - timeStamp) / 1000;
        System.out.println("La cajera " + this.nombre + " comienza a procesar la compra del cliente "
                + cliente.getNombre() + " en el tiempo " + tiempoInicio + " seg");

        int contProducto = 1;

        for (Producto producto : cliente.getProductos()) {
            this.esperarXSegundos();
            long tiempoProducto = (System.currentTimeMillis() - timeStamp) / 1000;
            System.out.println("* Procesando el producto " + contProducto
                    + ": nombre del producto: " + producto.getNombre()
                    + ", precio del producto: " + producto.getPrecio()
                    + ", cantidad de productos: " + producto.getCantidad()
                    + ", costo total del producto: " + (producto.getCantidad() * producto.getPrecio())
                    + " \n ------> Tiempo: " + tiempoProducto + " seg");
            contProducto++;
        }

        long tiempoFinal = (System.currentTimeMillis() - timeStamp) / 1000;
        System.out.println("La cajera " + this.nombre + " ha terminado de procesar al cliente " 
                + cliente.getNombre() + " en el tiempo: " + tiempoFinal + " seg");
        System.out.println("============================================================ \n");
    }

    /**
     * Simula una espera de 1 segundo.
     */
    private void esperarXSegundos() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            // Es buena práctica registrar o manejar la excepción en lugar de ignorarla.
            System.err.println("El hilo fue interrumpido: " + e.getMessage());
        }
    }
}
