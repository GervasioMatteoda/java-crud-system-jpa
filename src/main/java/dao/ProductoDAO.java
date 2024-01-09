package dao;

import dto.ProductoDTO;
import java.util.List;
import models.Producto;

public interface ProductoDAO {
    
    void altaProducto(Producto producto);
    List<Producto> buscarProducto();
    List<Producto> buscarProducto(ProductoDTO productoDTO);
    void modificarProducto (ProductoDTO productoDTO);
    void eliminarProducto (int id);
}
