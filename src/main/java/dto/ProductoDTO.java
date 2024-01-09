package dto;

import java.util.Date;
import models.CategoriaProductoEnum;

public class ProductoDTO {

    // Atributos
    private int id;
    private String nombre;
    private CategoriaProductoEnum categoria;
    private float precio;
    private int cantidad;
    private String descripcion;
    private Date ultimaModificacion;
    
    // Constructores - Getters - Setters
    public ProductoDTO() {
    }

    public ProductoDTO(String nombre, float precio, int cantidad, String descripcion, Date ultimaModificacion) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.ultimaModificacion = ultimaModificacion;
    }

    public CategoriaProductoEnum getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaProductoEnum categoria) {
        this.categoria = categoria;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getUltimaModificacion() {
        return ultimaModificacion;
    }

    public void setUltimaModificacion(Date ultimaModificacion) {
        this.ultimaModificacion = ultimaModificacion;
    }
}
