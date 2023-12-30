package trabajoautonomomyav.ventasonlinemyav.RepositorioMYAV;

import org.springframework.stereotype.Repository;
import trabajoautonomomyav.ventasonlinemyav.ModeloMYAV.AlmacenMYAV;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AlmacenRepositorioMYAV {
    private final List<AlmacenMYAV> almacenes = new ArrayList<>();
    public List<AlmacenMYAV> mostarTodosmyav() {
        return almacenes;
    }
    public AlmacenMYAV encontrarPorIDmyav(Long id) {
        return almacenes.stream()
                .filter(almacen -> almacen.getAlmacenIDMYAV().equals(id))
                .findFirst()
                .orElse(null);
    }
    public AlmacenMYAV guardarmyav(AlmacenMYAV almacen) {
        if (almacen.getAlmacenIDMYAV() == null) {
            almacen.setAlmacenIDMYAV((long) (almacenes.size() + 1));
            almacenes.add(almacen);
        } else {
            almacenes.removeIf(a -> a.getAlmacenIDMYAV().equals(almacen.getAlmacenIDMYAV()));
            almacenes.add(almacen);
        }
        return almacen;
    }
    public AlmacenMYAV actualizarmyav(AlmacenMYAV almacen) {
        for (int i = 0; i < almacenes.size(); i++) {
            if (almacenes.get(i).getAlmacenIDMYAV().equals(almacen.getAlmacenIDMYAV())) {
                almacenes.set(i, almacen);
                return almacen;
            }
        }
        return null;
    }
    public void deleteById(Long id) {
        almacenes.removeIf(almacen -> almacen.getAlmacenIDMYAV().equals(id));
    }
}
