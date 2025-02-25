package efinal2_api_pw_p7_dr.service;

import java.util.List;

import efinal2_api_pw_p7_dr.service.to.ProductoTo;



public interface IProductoService {

    public ProductoTo buscarPorId(Integer id);

    public void guardar(ProductoTo productoTo);
    public void guardarNormal(ProductoTo productoTo);
    public void actualiza(ProductoTo productoTo);
    public void borrar(Integer id);

    public ProductoTo buscarPorCodigoBarras(String codigoBarras);
    public ProductoTo buscarPorNombre( String nombre);

    public List<ProductoTo> listarProductos();
    
}
