package efinal2_api_pw_p7_dr.service;

import java.util.List;

import efinal2_api_pw_p7_dr.repository.model.Venta;
import efinal2_api_pw_p7_dr.service.to.VentaTo;

public interface IVentaService {

    public void ingresar(VentaTo ventaTo);
     public List<VentaTo> listar();
    
}
