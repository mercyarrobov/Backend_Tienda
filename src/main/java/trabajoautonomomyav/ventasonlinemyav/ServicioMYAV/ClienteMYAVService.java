package trabajoautonomomyav.ventasonlinemyav.ServicioMYAV;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trabajoautonomomyav.ventasonlinemyav.ModeloMYAV.ClienteMYAV;
import trabajoautonomomyav.ventasonlinemyav.RepositorioMYAV.ClienteRepositorioMYAV;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteMYAVService {
    @Autowired
    private ClienteRepositorioMYAV clienteRepositorioMYAV;
    public List<ClienteMYAV> getAllClientesmyav() {
        return clienteRepositorioMYAV.mostrarTodomyav();
    }
    public ClienteMYAV getClienteByIdmyav(Long id) {
        return clienteRepositorioMYAV.encontrarporIDmyav(id);
    }
    public ClienteMYAV guardarClientemyav(ClienteMYAV cliente) {
        return clienteRepositorioMYAV.guardarmyav(cliente);
    }
    public ClienteMYAV actualizarClientemyav(ClienteMYAV cliente) {
        return clienteRepositorioMYAV.actualizarmyav(cliente);
    }
    public void eliminarClientemyav(Long id) {
        clienteRepositorioMYAV.deleteById(id);
    }
}
