package trabajoautonomomyav.ventasonlinemyav.RepositorioMYAV;

import org.springframework.stereotype.Repository;
import trabajoautonomomyav.ventasonlinemyav.ModeloMYAV.RegistroOrdenesMYAV;

import java.util.ArrayList;
import java.util.List;
@Repository
public class RegistroOrdenesRepositorioMYAV {
    private final List<RegistroOrdenesMYAV> registrosOrdenes = new ArrayList<>();

    public RegistroOrdenesMYAV guardarmyav(RegistroOrdenesMYAV registroOrdenes) {
        if (registroOrdenes.getOrdenRIDMYAV() == null) {
            registroOrdenes.setOrdenRIDMYAV((long) (registrosOrdenes.size() + 1));
        } else {
            registrosOrdenes.removeIf(r -> r.getOrdenRIDMYAV().equals(registroOrdenes.getOrdenRIDMYAV()));
        }
        registrosOrdenes.add(registroOrdenes);
        return registroOrdenes;
    }

    public RegistroOrdenesMYAV buscarPorIDMYAV(Long id) {
        return registrosOrdenes.stream()
                .filter(registro -> registro.getOrdenRIDMYAV().compareTo(id) == 0)
                .findFirst()
                .orElse(null);
    }
}
