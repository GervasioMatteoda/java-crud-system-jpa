package models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.Digits;

@Entity
@Table (name = "Producto")
public class Producto implements Serializable {
    
    @Id
    @Column (name = "id")
    @Digits (integer = 5, fraction = 0, message = "El identificador debe tener exactamente 5 dígitos.")
    private Integer id;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column (name = "precio")
    private float precio;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "categoriaProducto")
    private CategoriaProductoEnum categoriaProducto;
    
    @Column (name = "cantidad")
    private int cantidad;
    
    @Column (name = "descripcion")
    private String descripcion;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column (name = "ultima_modificacion")
    private Date ultimaModificacion;
    
    // Constructores - Setters & Getters
    public Producto() {
    }

    public Producto(String nombre, float precio, int cantidad, Date ultimaModificacion) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.ultimaModificacion = ultimaModificacion;
    }

    public Producto(String nombre, float precio, CategoriaProductoEnum categoriaProducto, int cantidad, String descripcion, Date ultimaModificacion) {
        this.nombre = nombre;
        this.precio = precio;
        this.categoriaProducto = categoriaProducto;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.ultimaModificacion = ultimaModificacion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public CategoriaProductoEnum getCategoriaProducto() {
        return categoriaProducto;
    }

    public void setCategoriaProducto(CategoriaProductoEnum categoriaProducto) {
        this.categoriaProducto = categoriaProducto;
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