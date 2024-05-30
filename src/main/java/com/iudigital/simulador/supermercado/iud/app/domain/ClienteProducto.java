package com.iudigital.simulador.supermercado.iud.app.domain;

import java.util.List;

/**
 * La clase ClienteProducto representa un cliente y la lista de productos que ha adquirido.
 * Incluye métodos para obtener el nombre del cliente y la lista de productos.
 * 
 * @autor Andri
 */
public class ClienteProducto {
    
    // Atributo que almacena el nombre del cliente
    private final String nombre;
    
    // Lista de productos asociados al cliente
    private final List<Producto> productos;

    /**
     * Constructor de la clase ClienteProducto.
     *
     * @param nombre El nombre del cliente
     * @param productos La lista de productos adquiridos por el cliente
     */
    public ClienteProducto(String nombre, List<Producto> productos) {
        this.nombre = nombre;
        this.productos = productos;
    }

    /**
     * Obtiene el nombre del cliente.
     *
     * @return El nombre del cliente
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene la lista de productos adquiridos por el cliente.
     *
     * @return La lista de productos
     */
    public List<Producto> getProductos() {
        return productos;
    }
}

