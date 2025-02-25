package efinal2_api_pw_p7_dr.service;

import java.util.List;
import java.util.function.Function;

import efinal2_api_pw_p7_dr.repository.IVentaRepository;
import efinal2_api_pw_p7_dr.repository.model.Venta;
import efinal2_api_pw_p7_dr.service.to.VentaTo;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class VentaServiceImpl implements IVentaService{

    @Inject 
    private IVentaRepository ventaRepository;




    //MapTO de VENTA 
    private Function<VentaTo, Venta> mapToVenta = ventaTo -> {
        Venta venta = new Venta();
        venta.setNumeroVenta(ventaTo.getNumeroVenta());
        venta.setCedulaCliente(ventaTo.getCedulaCliente());
        venta.setTotalVenta(ventaTo.getTotalVenta());
        return venta;
    };

    //PASAR A TO
    private Function<Venta, VentaTo> mapToVentaTo = venta -> {
        VentaTo ventaTo = new VentaTo();
        ventaTo.setNumeroVenta(venta.getNumeroVenta());
        ventaTo.setCedulaCliente(venta.getCedulaCliente());
        ventaTo.setTotalVenta(venta.getTotalVenta());
        return ventaTo;
    };

    @Override
    public void ingresar(VentaTo ventaTo) {
    
        this.ventaRepository.ingresar(mapToVenta.apply(ventaTo));
    }

    @Override
    public List<VentaTo> listar() {
        return this.ventaRepository.listar().stream().map(mapToVentaTo).toList();
    }
    
}
