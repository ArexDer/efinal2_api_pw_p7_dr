package efinal2_api_pw_p7_dr.repository;

import java.util.List;

import efinal2_api_pw_p7_dr.repository.model.Producto;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class ProductoRepositoryImpl implements IProductoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Producto buscarPorId(Integer id) {
        
        return this.entityManager.find(Producto.class, 1);
    }

    @Override
    public void ingresar(Producto producto) {
        
        this.entityManager.persist(producto);
    }

    @Override
    public void actualiza(Producto producto) {
        
        this.entityManager.merge(producto);
    }

    @Override
    public void eliminar(Integer id) {
        this.entityManager.remove(buscarPorId(id));
    }

    @Override
    public Producto buscarPorCodigoBarras(String codBarras) {
        TypedQuery<Producto> query = this.entityManager.createQuery("SELECT p FROM Producto p WHERE p.codigoBarras = :codBarras", Producto.class);
        query.setParameter("codBarras", codBarras);
        return query.getSingleResult();
        
        
    }

    @Override
    public Producto buscarPorNombre(String nombre) {
        TypedQuery<Producto> query = this.entityManager.createQuery("SELECT p FROM Producto p WHERE p.nombre = :nombre", Producto.class);
        query.setParameter("nombre", nombre);
        return query.getSingleResult();
    }

    @Override
    public List<Producto> listarProductos() {
        TypedQuery<Producto> query = this.entityManager.createQuery("SELECT p FROM Producto p", Producto.class);
        return query.getResultList();
    }
    
}
