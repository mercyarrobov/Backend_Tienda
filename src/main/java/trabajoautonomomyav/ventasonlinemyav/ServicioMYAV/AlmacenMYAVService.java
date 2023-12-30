package trabajoautonomomyav.ventasonlinemyav.ServicioMYAV;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trabajoautonomomyav.ventasonlinemyav.ModeloMYAV.AlmacenMYAV;
import trabajoautonomomyav.ventasonlinemyav.RepositorioMYAV.AlmacenRepositorioMYAV;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlmacenMYAVService {
    @Autowired
    private AlmacenRepositorioMYAV almacenRepository;
    public List<AlmacenMYAV> getAllAlmacenesmyav() {
        return almacenRepository.mostarTodosmyav();
    }
    public AlmacenMYAV getAlmacenByIdmyav(Long id) {
        return almacenRepository.encontrarPorIDmyav(id);
    }
    public AlmacenMYAV saveAlmacenmyav(AlmacenMYAV almacen) {
        return almacenRepository.guardarmyav(almacen);
    }
    public AlmacenMYAV actualizarAlmacenmyav(AlmacenMYAV almacen) {
        return almacenRepository.actualizarmyav(almacen);
    }
    public void eliminarAlmacenmyav(Long id) {
        almacenRepository.deleteById(id);
    }
}
