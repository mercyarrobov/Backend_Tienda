package trabajoautonomomyav.ventasonlinemyav.ServicioMYAV;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trabajoautonomomyav.ventasonlinemyav.ModeloMYAV.ProductoMYAV;
import trabajoautonomomyav.ventasonlinemyav.ModeloMYAV.RegistroOrdenesMYAV;
import trabajoautonomomyav.ventasonlinemyav.RepositorioMYAV.ProductoRepositorioMYAV;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoMYAVService {
    private final ProductoRepositorioMYAV productoRepositorioMYAV;
    private final RegistroOrdenesMYAVService registroOrdenesMYAVService;
    @Autowired
    public ProductoMYAVService(ProductoRepositorioMYAV productoRepositorioMYAV,
                               RegistroOrdenesMYAVService registroOrdenesMYAVService) {
        this.productoRepositorioMYAV = productoRepositorioMYAV;
        this.registroOrdenesMYAVService = registroOrdenesMYAVService;
    }
    public List<ProductoMYAV> buscarTodoMYAV() {
        return productoRepositorioMYAV.buscarTodoMYAV();
    }
    public ProductoMYAV buscarPorIDMYAV(Long id) {
        return productoRepositorioMYAV.buscarPorIDMYAV(id);
    }
    public ProductoMYAV guardarMYAV(ProductoMYAV producto) {
        // Obtén la orden por ID
        RegistroOrdenesMYAV orden = registroOrdenesMYAVService.buscarPorIDMYAV(producto.getOrdenRIDMYAV().getOrdenRIDMYAV());

        // Verifica si la orden existe
        if (orden != null) {
            // Asocia la orden con el nuevo producto
            producto.setOrdenRIDMYAV(orden);

            // Guarda el producto
            return productoRepositorioMYAV.guardarMYAV(producto);
        } else {
            // Maneja el caso donde la orden no existe
            throw new RuntimeException("No se pudo guardar el producto. La orden especificada no existe.");        }
    }
    public ProductoMYAV actualizarMYAV(Long id, ProductoMYAV nuevoProducto) {
        // Busca el producto existente por ID
        ProductoMYAV productoExistente = productoRepositorioMYAV.buscarPorIDMYAV(id);

        // Verifica si el producto existe antes de actualizar
        if (productoExistente != null) {
            // Copia los nuevos valores al producto existente
            productoExistente.setNombreProductoMYAV(nuevoProducto.getNombreProductoMYAV());
            productoExistente.setPrecioMYAV(nuevoProducto.getPrecioMYAV());

            // Guarda el producto actualizado
            return productoRepositorioMYAV.guardarMYAV(productoExistente);
        } else {
            // Maneja el caso donde el producto no existe
            return null;
        }
    }

    public void eliminarPorIDMYAV(Long id) {
        productoRepositorioMYAV.eliminarPorIDMYAV(id);
    }
}
