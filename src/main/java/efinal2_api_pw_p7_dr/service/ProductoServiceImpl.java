package efinal2_api_pw_p7_dr.service;

import java.util.List;
import java.util.function.Function;

import efinal2_api_pw_p7_dr.repository.IProductoRepository;
import efinal2_api_pw_p7_dr.repository.model.Producto;
import efinal2_api_pw_p7_dr.service.to.ProductoTo;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ProductoServiceImpl implements IProductoService {


    @Inject
    private IProductoRepository iproductoRepository;

    //METODOS DE MAPEOTO E INVERSO
    private Function<Producto, ProductoTo> mapToProductoTo = producto -> {
        ProductoTo productoTo = new ProductoTo();
        productoTo.setId(producto.getId());
        productoTo.setCodigoBarras(producto.getCodigoBarras());
        productoTo.setNombre(producto.getNombre());
        productoTo.setCategoria(producto.getCategoria());
        productoTo.setStock(producto.getStock());
        productoTo.setPrecio(producto.getPrecio());
        productoTo.setDetallesVenta(producto.getDetallesVenta());
        return productoTo;
    };
    private Function<ProductoTo, Producto> reverso = productoTo -> {
        Producto producto = new Producto();
        producto.setId(productoTo.getId());
        producto.setCodigoBarras(productoTo.getCodigoBarras());
        producto.setNombre(productoTo.getNombre());
        producto.setCategoria(productoTo.getCategoria());
        producto.setStock(productoTo.getStock());
        producto.setPrecio(productoTo.getPrecio());
        producto.setDetallesVenta(productoTo.getDetallesVenta());
        return producto;
    };

    @Override
    public ProductoTo buscarPorId(Integer id) {
        
        return mapToProductoTo.apply(this.iproductoRepository.buscarPorId(id));
    }

    @Override
public void guardar(ProductoTo productoTo) {
    // VALIDO PRIMERO QUE EL PRODUCTO EXISTA Y SUMO EL STOCK CASO CONTRARIO CREO UN NUEVO PRODUCTO

    Producto producto = reverso.apply(productoTo);

    try {
        Producto productoExistente = this.iproductoRepository.buscarPorCodigoBarras(producto.getCodigoBarras());

        if (productoExistente != null) {
            productoExistente.setStock(productoExistente.getStock() + producto.getStock());
            this.iproductoRepository.actualiza(productoExistente);
        } else {
            this.iproductoRepository.ingresar(producto);
        }
    } catch (jakarta.persistence.NoResultException e) {
        // Si no se encuentra el producto, se crea uno nuevo
        this.iproductoRepository.ingresar(producto);
    }
}

    @Override
    public void actualiza(ProductoTo productoTo) {
        //ACTUALIZO MI PRODUCTO
        this.iproductoRepository.actualiza(reverso.apply(productoTo));

    }

    @Override
    public void borrar(Integer id) {
        
        this.iproductoRepository.eliminar(id);
    }

    @Override
    public ProductoTo buscarPorCodigoBarras(String codigoBarras) {
       return  this.mapToProductoTo.apply(this.iproductoRepository.buscarPorCodigoBarras(codigoBarras));
    }

    @Override
    public ProductoTo buscarPorNombre(String nombre) {
        return this.mapToProductoTo.apply(this.iproductoRepository.buscarPorNombre(nombre));
    }

    @Override
    public List<ProductoTo> listarProductos() {


        return this.iproductoRepository.listarProductos().stream().map(mapToProductoTo).toList();

    }

    @Override
    public void guardarNormal(ProductoTo productoTo) {
        
        this.iproductoRepository.ingresar(reverso.apply(productoTo));
    }

    
}
