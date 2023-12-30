package trabajoautonomomyav.ventasonlinemyav.ControladorMYAV;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trabajoautonomomyav.ventasonlinemyav.ModeloMYAV.ProductoMYAV;
import trabajoautonomomyav.ventasonlinemyav.ServicioMYAV.ProductoMYAVService;

import java.util.List;

@RestController
@RequestMapping("/productosmyav")
public class ProductoControladorMYAV {
    @Autowired
    private ProductoMYAVService productoService;

    @GetMapping
    public List<ProductoMYAV> buscarTodoMYAV() {
        return productoService.buscarTodoMYAV();
    }

    @GetMapping("/{id}")
    public ProductoMYAV buscarPorIDMYAV(@PathVariable Long id) {
        return productoService.buscarPorIDMYAV(id);
    }

    @PostMapping
    public ProductoMYAV guardarMYAV(@RequestBody ProductoMYAV producto) {
        return productoService.guardarMYAV(producto);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ProductoMYAV> actualizarProducto(@PathVariable Long id, @RequestBody ProductoMYAV producto) {
        ProductoMYAV productoActualizado = productoService.actualizarMYAV(id, producto);

        if (productoActualizado != null) {
            return new ResponseEntity<>(productoActualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public void eliminarPorIDMYAV(@PathVariable Long id) {
        productoService.eliminarPorIDMYAV(id);
    }
}
