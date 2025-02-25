package efinal2_api_pw_p7_dr.repository;

import java.util.List;

import efinal2_api_pw_p7_dr.repository.model.Producto;

public interface IProductoRepository {

    public Producto buscarPorId(Integer id);

    public void ingresar(Producto producto);
    public void actualiza(Producto producto);
    public void eliminar(Integer id);

    public Producto buscarPorCodigoBarras(String codigoBarras);
    public Producto buscarPorNombre( String nombre);

    public List<Producto> listarProductos();

    
    
}
