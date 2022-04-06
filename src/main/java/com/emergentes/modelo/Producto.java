package com.emergentes.modelo;

public class Producto {

    private int id;
    private String descripcion;
    private String categoria;
    private int cantidad;
    private float precio;

    public Producto() {
        this.id = 0;
        this.descripcion = "";
        this.cantidad = 0;
        this.precio = 0;
        this.categoria = "";
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public float getPrecio() {
        return precio;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
}
