package trabajoautonomomyav.ventasonlinemyav.ServicioMYAV;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trabajoautonomomyav.ventasonlinemyav.ModeloMYAV.AlmacenMYAV;
import trabajoautonomomyav.ventasonlinemyav.ModeloMYAV.ClienteMYAV;
import trabajoautonomomyav.ventasonlinemyav.ModeloMYAV.RegistroOrdenesMYAV;
import trabajoautonomomyav.ventasonlinemyav.RepositorioMYAV.RegistroOrdenesRepositorioMYAV;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class RegistroOrdenesMYAVService {
    private final RegistroOrdenesRepositorioMYAV registroOrdenesMYAVRepository;
    private final ClienteMYAVService clienteMYAVService;
    private final AlmacenMYAVService almacenMYAVService;
    @Autowired
    public RegistroOrdenesMYAVService(RegistroOrdenesRepositorioMYAV registroOrdenesMYAVRepository,
                                      ClienteMYAVService clienteMYAVService,
                                      AlmacenMYAVService almacenMYAVService) {
        this.registroOrdenesMYAVRepository = registroOrdenesMYAVRepository;
        this.clienteMYAVService = clienteMYAVService;
        this.almacenMYAVService = almacenMYAVService;
    }
    public RegistroOrdenesMYAV guardarRegistroOrdenes(RegistroOrdenesMYAV registroOrdenesMYAV) {
        ClienteMYAV cliente = clienteMYAVService.getClienteByIdmyav(registroOrdenesMYAV.getClienteIDMYAV().getClienteIDMYAV());
        AlmacenMYAV almacen = almacenMYAVService.getAlmacenByIdmyav(registroOrdenesMYAV.getAlmacenIDMYAV().getAlmacenIDMYAV());
        if (cliente != null && almacen != null) {
            registroOrdenesMYAV.setClienteIDMYAV(cliente);
            registroOrdenesMYAV.setAlmacenIDMYAV(almacen);

            return registroOrdenesMYAVRepository.guardarmyav(registroOrdenesMYAV);
        } else {
            return null;
        }
    }
    public RegistroOrdenesMYAV buscarPorIDMYAV(Long id) {
        return registroOrdenesMYAVRepository.buscarPorIDMYAV(id);
    }
}
