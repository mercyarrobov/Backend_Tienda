package trabajoautonomomyav.ventasonlinemyav.ControladorMYAV;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trabajoautonomomyav.ventasonlinemyav.ModeloMYAV.AlmacenMYAV;
import trabajoautonomomyav.ventasonlinemyav.ServicioMYAV.AlmacenMYAVService;

import java.util.List;

@RestController
@RequestMapping("/almacenesmyav")
public class AlmacenControladorMYAV {
    @Autowired
    private AlmacenMYAVService almacenService;

    @GetMapping
    public List<AlmacenMYAV> getAllAlmacenesmyav() {
        return almacenService.getAllAlmacenesmyav();
    }
    @GetMapping("/{id}")
    public AlmacenMYAV getAlmacenByIdmyav(@PathVariable Long id) {
        return almacenService.getAlmacenByIdmyav(id);
    }
    @PostMapping
    public AlmacenMYAV saveAlmacenmyav(@RequestBody AlmacenMYAV almacen) {
        return almacenService.saveAlmacenmyav(almacen);
    }
    @PutMapping("/{id}")
    public ResponseEntity<AlmacenMYAV> actualizarAlmacenmyav(@PathVariable Long id, @RequestBody AlmacenMYAV almacen) {
        almacen.setAlmacenIDMYAV(id);
        AlmacenMYAV almacenActualizado = almacenService.actualizarAlmacenmyav(almacen);
        if (almacenActualizado != null) {
            return new ResponseEntity<>(almacenActualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public void eliminarAlmacenmyav(@PathVariable Long id) {
        almacenService.eliminarAlmacenmyav(id);
    }
}
