package controllers;

import dao.ProductoDAOImpl;
import dto.ProductoDTO;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import models.Producto;
import util.GestorException;

public class GestorProducto {
    
    EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("com.sistema-crud");
    EntityManager manager = managerFactory.createEntityManager();
    
    Producto producto;
    ProductoDTO productoDTO;
    ProductoDAOImpl productoImpl;
    
    public boolean crearProducto (ProductoDTO productoDTO) {
        try {
            productoImpl = new ProductoDAOImpl(manager);
            producto = new Producto(productoDTO.getNombre(), productoDTO.getPrecio(), productoDTO.getCategoria(), productoDTO.getCantidad(), productoDTO.getDescripcion(), productoDTO.getUltimaModificacion());
            productoImpl.altaProducto(producto);
            return true;
        } catch (Exception e) {
            throw new GestorException("Error: Crear Producto", e);
        }
    }
    
    public List<ProductoDTO> buscarProducto (ProductoDTO productoDTO) {
        try {
            productoImpl = new ProductoDAOImpl(manager);
            List<Producto> productos = productoImpl.buscarProducto(productoDTO);
            List<ProductoDTO> productosDTO = new ArrayList<>();
            for (Producto p : productos) {
                ProductoDTO pDTO = new ProductoDTO(p.getNombre(), p.getPrecio(), p.getCantidad(), p.getDescripcion(), p.getUltimaModificacion());
                pDTO.setId(p.getId());
                productosDTO.add(pDTO);
            }
            return productosDTO;
        } catch (Exception e) {
            throw new GestorException("Error: Buscar Producto", e);
        }
    }
    
    public boolean eliminarProducto (int id) {
        try {
            productoImpl = new ProductoDAOImpl(manager);
            productoImpl.eliminarProducto(id);
            return true;
        } catch (Exception e) {
            throw new GestorException("Error: Eliminar Producto", e);
        }
    }
    
    public boolean modificarProducto(ProductoDTO productoDTO) {
        try {
            productoImpl = new ProductoDAOImpl(manager);
            productoImpl.modificarProducto(productoDTO);
            return true;
        } catch (Exception e) {
            throw new GestorException("Error: Modificar Producto", e);
        }
    }

}
