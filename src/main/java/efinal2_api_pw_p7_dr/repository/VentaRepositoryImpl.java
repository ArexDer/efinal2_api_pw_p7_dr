package efinal2_api_pw_p7_dr.repository;

import java.util.List;

import org.jboss.resteasy.core.MediaTypeMap.Typed;

import efinal2_api_pw_p7_dr.repository.model.Venta;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
@ApplicationScoped
@Transactional
public class VentaRepositoryImpl implements IVentaRepository {

    @PersistenceContext     
    private EntityManager entityManager;

    @Override
    public void ingresar(Venta venta) {
        this.entityManager.persist(venta);
    }

    @Override
    public List<Venta> listar() {
        TypedQuery<Venta> query = this.entityManager.createQuery("SELECT v FROM Venta v", Venta.class);
        return query.getResultList();
    }

  
    
}
