package efinal2_api_pw_p7_dr.service.to;

import jakarta.persistence.Column;

public class VentaTo {

     private Integer id;
    private String numeroVenta;
    private String cedulaCliente;

    private Double totalVenta;

    public VentaTo(Integer id, String numeroVenta, String cedulaCliente, Double totalVenta) {
        this.id = id;
        this.numeroVenta = numeroVenta;
        this.cedulaCliente = cedulaCliente;
        this.totalVenta = totalVenta;
    }

    public VentaTo(String numeroVenta, String cedulaCliente) {
     
        this.numeroVenta = numeroVenta;
        this.cedulaCliente = cedulaCliente;
      
    }

    
    public VentaTo() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumeroVenta() {
        return numeroVenta;
    }

    public void setNumeroVenta(String numeroVenta) {
        this.numeroVenta = numeroVenta;
    }

    public String getCedulaCliente() {
        return cedulaCliente;
    }

    public void setCedulaCliente(String cedulaCliente) {
        this.cedulaCliente = cedulaCliente;
    }

    public Double getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(Double totalVenta) {
        this.totalVenta = totalVenta;
    }

    

    
}
