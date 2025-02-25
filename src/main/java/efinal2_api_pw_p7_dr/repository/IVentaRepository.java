package efinal2_api_pw_p7_dr.repository;

import java.util.List;

import efinal2_api_pw_p7_dr.repository.model.Venta;

public interface IVentaRepository {

    public void ingresar(Venta venta);

    public List<Venta> listar();
    
}
