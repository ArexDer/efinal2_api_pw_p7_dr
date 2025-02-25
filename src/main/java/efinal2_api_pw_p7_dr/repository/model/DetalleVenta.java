package efinal2_api_pw_p7_dr.repository.model;

import org.hibernate.annotations.Index;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "detalle_venta")
public class DetalleVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "detalle_venta_seq")
    @SequenceGenerator(name = "detalle_venta_seq", sequenceName = "detalle_venta_seq", allocationSize = 1)
    @Column(name = "deta_id")
    private Integer id;
    @Column(name = "deta_cantidad")
    private Integer Cantidad;
    @Column(name = "deta_precio_unitario")
    private Double precioUnitario;
    @Column(name = "deta_sub_total")
    private Double subTotal;


    //MAPEO DE MODELO VENTA Y PRODUCTO
    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "venta_id")
    private Venta venta;


    //---------------------------
    public DetalleVenta() {
    }
    

    public DetalleVenta(Integer id, Integer cantidad, Double precioUnitario, Double subTotal, Producto producto,
            Venta venta) {
        this.id = id;
        Cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.subTotal = subTotal;
        this.producto = producto;
        this.venta = venta;
    }


    //---------------------------------------
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return Cantidad;
    }

    public void setCantidad(Integer cantidad) {
        Cantidad = cantidad;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }




    
    
    
}
