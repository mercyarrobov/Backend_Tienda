package trabajoautonomomyav.ventasonlinemyav.RepositorioMYAV;

import org.springframework.stereotype.Repository;
import trabajoautonomomyav.ventasonlinemyav.ModeloMYAV.ProductoMYAV;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductoRepositorioMYAV {
    private final List<ProductoMYAV> productos = new ArrayList<>();
    public List<ProductoMYAV> buscarTodoMYAV() {
        return productos;
    }
    public ProductoMYAV buscarPorIDMYAV(Long id) {
        return productos.stream()
                .filter(producto -> producto.getProductoIdMYAV().equals(id))
                .findFirst()
                .orElse(null);
    }
    public ProductoMYAV guardarMYAV(ProductoMYAV producto) {
        productos.add(producto);
        return producto;
    }
    public ProductoMYAV actualizarMYAV(ProductoMYAV producto) {
        for (int i = 0; i < productos.size(); i++) {
            ProductoMYAV p = productos.get(i);
            if (p.getProductoIdMYAV().equals(producto.getProductoIdMYAV())) {
                productos.set(i, producto);
                return producto;
            }
        }
        return null;
    }
    public void eliminarPorIDMYAV(Long id) {
        productos.removeIf(producto -> producto.getProductoIdMYAV().equals(id));
    }
}
