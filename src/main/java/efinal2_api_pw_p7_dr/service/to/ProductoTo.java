package efinal2_api_pw_p7_dr.service.to;

import java.util.List;

import efinal2_api_pw_p7_dr.repository.model.DetalleVenta;
import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;

public class ProductoTo {

     private Integer id;
   
    private String codigoBarras;
  
    private String nombre;
  
    private String categoria;
  
    private Integer stock;
   
    private Double precio;

    @JsonbTransient
    private List<DetalleVenta> detallesVenta;


    public ProductoTo() {
    }

    
    //CONTRSUCTORES    

    public ProductoTo(Integer id, String codigoBarras, String nombre, String categoria, Integer stock, Double precio,
            List<DetalleVenta> detallesVenta) {
        this.id = id;
        this.codigoBarras = codigoBarras;
        this.nombre = nombre;
        this.categoria = categoria;
        this.stock = stock;
        this.precio = precio;
        this.detallesVenta = detallesVenta;
    }


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

    

    
}
