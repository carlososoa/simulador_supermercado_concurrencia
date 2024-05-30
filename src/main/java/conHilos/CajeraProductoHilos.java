package conHilos;

import com.iudigital.simulador.supermercado.iud.app.domain.ClienteProducto;
import com.iudigital.simulador.supermercado.iud.app.domain.Producto;

/**
 * La clase CajeraProductoHilos simula el procesamiento de compras de un cliente por una cajera en un hilo separado.
 * Implementa la interfaz Runnable para permitir la ejecución en un hilo.
 * 
 * @autor Andri
 */
public class CajeraProductoHilos implements Runnable {
    
    private String nombre;
    private ClienteProducto cliente;
    private long timeStamp;
    private String identificador;
    
    /**
     * Constructor de la clase CajeraProductoHilos.
     * 
     * @param nombre El nombre de la cajera
     * @param cliente El cliente cuyas compras serán procesadas
     * @param timeStamp El tiempo de inicio del procesamiento en milisegundos
     * @param identificador Identificador para distinguir las salidas de distintas cajeras
     */
    public CajeraProductoHilos(String nombre, ClienteProducto cliente, long timeStamp, String identificador) {
        this.nombre = nombre;
        this.cliente = cliente;
        this.timeStamp = timeStamp;
        this.identificador = identificador;
    }
    
    /**
     * Método que se ejecuta al iniciar el hilo.
     * Llama al método procesarCompra para simular el procesamiento de la compra.
     */
    @Override
    public void run() {   
        this.procesarCompra(this.cliente, this.timeStamp);       
    }
    
    /**
     * Procesa la compra de los productos de un cliente.
     * 
     * @param cliente El cliente cuyas compras serán procesadas
     * @param timeStamp El tiempo de inicio del procesamiento en milisegundos
     */
    public void procesarCompra(ClienteProducto cliente, long timeStamp) {
        long tiempoInicio = (System.currentTimeMillis() - timeStamp) / 1000;
        System.out.println(this.identificador + " La cajera " + this.nombre + " comienza a procesar la compra del cliente "
                + cliente.getNombre() + " en el tiempo " + tiempoInicio + " seg ");

        int contProducto = 1;
        float totalCompra = 0;

        for (Producto producto : cliente.getProductos()) {
            this.esperarXSegundos();
            float costoTotalProducto = producto.getCantidad() * producto.getPrecio();
            long tiempoProducto = (System.currentTimeMillis() - timeStamp) / 1000;
            String mensaje = this.identificador + " " + this.nombre + " Procesando el producto " + contProducto
                    + " nombre producto: " + producto.getNombre()
                    + " precio producto: " + producto.getPrecio()
                    + " cantidad de productos: " + producto.getCantidad()
                    + " costo total del producto: " + costoTotalProducto
                    + " -> Tiempo: " + tiempoProducto + " seg";            
            
            System.out.println(mensaje);
            
            totalCompra += costoTotalProducto;
            contProducto++;
        }

        long tiempoFinal = (System.currentTimeMillis() - timeStamp) / 1000;
        System.out.println(this.identificador + " La cajera " + this.nombre + " ha terminado de procesar al cliente " 
                + cliente.getNombre() + " , total de la compra: $" + totalCompra
                + " en el tiempo: " + tiempoFinal + " seg");
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