package com.iudigital.simulador.supermercado.iud.app.domain;

/**
 * La clase Producto representa un producto en el supermercado.
 * Incluye atributos para el nombre, precio y cantidad del producto,
 * así como métodos para obtener y establecer estos valores.
 * 
 * @autor Andri
 */
public class Producto {
    
    // Atributo que determina el nombre del producto
    private String nombre;
    
    // Atributo que determina el precio del producto
    private float precio;
    
    // Atributo que determina la cantidad del producto
    private int cantidad;
    
    /**
     * Constructor de la clase Producto.
     * 
     * @param nombre El nombre del producto
     * @param precio El precio del producto
     * @param cantidad La cantidad del producto
     */   
    public Producto(String nombre, float precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    /**
     * Obtiene el nombre del producto.
     * 
     * @return El nombre del producto
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del producto.
     * 
     * @param nombre El nuevo nombre del producto
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la cantidad del producto.
     * 
     * @return La cantidad del producto
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Establece la cantidad del producto.
     * 
     * @param cantidad La nueva cantidad del producto
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Obtiene el precio del producto.
     * 
     * @return El precio del producto
     */
    public float getPrecio() {
        return precio;
    }
}
