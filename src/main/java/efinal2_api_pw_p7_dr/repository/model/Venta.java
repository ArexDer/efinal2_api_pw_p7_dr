package efinal2_api_pw_p7_dr.repository.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "venta")
public class Venta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "venta_seq")
    @SequenceGenerator(name = "venta_seq", sequenceName = "venta_seq", allocationSize = 1)
    @Column(name = "vent_id")
    private Integer id;
    @Column(name = "vent_numero_venta")
    private String numeroVenta;

    @Column(name = "vent_cedula_cliente")
    private String cedulaCliente;
    @Column(name = "vent_total_venta")
    private Double totalVenta;

    public Venta() {
    }

    public Venta(Integer id, String numeroVenta, String cedulaCliente, Double totalVenta,
            List<DetalleVenta> detallesVenta) {
        this.id = id;
        this.numeroVenta = numeroVenta;
        this.cedulaCliente = cedulaCliente;
        this.totalVenta = totalVenta;
        this.detallesVenta = detallesVenta;
    }

    //MAPEO DE MODELO DETALLE VENTA
     @OneToMany(mappedBy = "venta")
    private List<DetalleVenta> detallesVenta;

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

    public List<DetalleVenta> getDetallesVenta() {
        return detallesVenta;
    }

    public void setDetallesVenta(List<DetalleVenta> detallesVenta) {
        this.detallesVenta = detallesVenta;
    }


    


}
