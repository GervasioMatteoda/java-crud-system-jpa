package dao;

import dto.ProductoDTO;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import models.Producto;
import util.DAOException;

public class ProductoDAOImpl implements ProductoDAO {

    private final EntityManager entityManager;
    
    public ProductoDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    @Override
    public void altaProducto(Producto producto) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(producto);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            throw new DAOException("Error: Crear Producto", e);
        }
    }

    @Override
    public List<Producto> buscarProducto() {
        try{
            String consulta = "SELECT p FROM Producto p  ORDER BY p.id ASC";
            TypedQuery<Producto> query = (TypedQuery<Producto>) entityManager.createQuery(consulta);
            return query.getResultList();
        } catch (NoResultException e) {
            return Collections.emptyList();
        } catch (Exception e) {
            throw new DAOException("Error: Buscar Producto", e);
        }
    }

    @Override
    public List<Producto> buscarProducto(ProductoDTO productoDTO) {
        try{
            String consulta = "SELECT p FROM Producto p WHERE 1=1"; //ver si se concatena con otra tabla
            
            if(!(productoDTO.getNombre().isEmpty())){
                consulta = (consulta + " AND p.nombre = :nombre");
            }
            if(!(productoDTO.getCategoria()!= null)){
                consulta = (consulta + " AND p.categoria = :categoria");
            }
            if(!(productoDTO.getPrecio() != 0)){
                consulta = (consulta + " AND p.precio = :precio");
            }
            if(productoDTO.getCantidad() != 0){
                consulta = (consulta + " AND p.cantidad = :cantidad");
            }

            TypedQuery<Producto> query = (TypedQuery<Producto>) entityManager.createQuery(consulta);

            if(productoDTO.getNombre().equals("")){
                query.setParameter("nombre", productoDTO.getId() + "%");
            }
            if(!(productoDTO.getCategoria()!= null)){
                query.setParameter("categoria", productoDTO.getCategoria());
            }
            if(!(productoDTO.getPrecio() != 0)){
                query.setParameter("precio", productoDTO.getPrecio());
            }
            if(productoDTO.getCantidad() != 0){
                query.setParameter("cantidad", productoDTO.getCantidad());
            }
            return query.getResultList();
        } catch (NoResultException e) {
            return Collections.emptyList();
        } catch (Exception e) {
            throw new DAOException("Error: Buscar Producto", e);
        }
    }

    @Override
    public void modificarProducto(ProductoDTO productoDTO) {
        try {
            Producto producto = entityManager.find(Producto.class, productoDTO.getId());
                if (producto != null) {
                    producto.setNombre(productoDTO.getNombre());
                    producto.setDescripcion(productoDTO.getDescripcion());
                    producto.setCantidad(productoDTO.getCantidad());
                    producto.setPrecio(productoDTO.getPrecio());
                    producto.setUltimaModificacion(new Date());
                    
                    entityManager.getTransaction().begin();
                    entityManager.remove(producto);
                    entityManager.getTransaction().commit();
                } else {
                    throw new DAOException("Error: Modificar Producto");
                }
        } catch (Exception e) {
            throw new DAOException("Error: Modificar Producto", e);
        }
    }

    @Override
    public void eliminarProducto(int id) {
        try {
            Producto producto = entityManager.find(Producto.class, id);
                if (producto != null) {
                    entityManager.getTransaction().begin();
                    entityManager.remove(producto);
                    entityManager.getTransaction().commit();
                } else {
                    throw new DAOException("Error: Eliminar Producto");
                }
        } catch (Exception e) {
            throw new DAOException("Error: Eliminar Producto", e);
        }
    }
    
}
