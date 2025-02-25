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
@Table(name = "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "producto_seq")
    @SequenceGenerator(name = "producto_seq", sequenceName = "producto_seq", allocationSize = 1)
    @Column(name = "prod_id")
    private Integer id;
    @Column(name = "prod_codigo_barras")
    private String codigoBarras;
    @Column(name = "prod_nombre")
    private String nombre;
    @Column(name = "prod_categoria")
    private String categoria;
    @Column(name = "prod_stock")
    private Integer stock;
    @Column(name = "prod_precio")
    private Double precio;


    public Producto() {
    }

    public Producto(Integer id, String codigoBarras, String nombre, String categoria, Integer stock, Double precio,
            List<DetalleVenta> detallesVenta) {
        this.id = id;
        this.codigoBarras = codigoBarras;
        this.nombre = nombre;
        this.categoria = categoria;
        this.stock = stock;
        this.precio = precio;
        this.detallesVenta = detallesVenta;
    }

    //MAPEO MODELO DETALLE VENTA
    @OneToMany(mappedBy = "producto")
    private List<DetalleVenta> detallesVenta;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public List<DetalleVenta> getDetallesVenta() {
        return detallesVenta;
    }

    public void setDetallesVenta(List<DetalleVenta> detallesVenta) {
        this.detallesVenta = detallesVenta;
    }

    //METODSO GETTERS AND SETTERS
    








    
}
