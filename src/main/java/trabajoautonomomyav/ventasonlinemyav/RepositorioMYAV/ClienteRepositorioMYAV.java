package trabajoautonomomyav.ventasonlinemyav.RepositorioMYAV;

import org.springframework.stereotype.Repository;
import trabajoautonomomyav.ventasonlinemyav.ModeloMYAV.ClienteMYAV;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ClienteRepositorioMYAV {
    private final List<ClienteMYAV> clientes = new ArrayList<>();
    public List<ClienteMYAV> mostrarTodomyav() {
        return clientes;
    }
    public ClienteMYAV encontrarporIDmyav(Long id) {
        return clientes.stream()
                .filter(cliente -> cliente.getClienteIDMYAV().equals(id))
                .findFirst()
                .orElse(null);
    }
    public ClienteMYAV guardarmyav(ClienteMYAV cliente) {
        if (cliente.getClienteIDMYAV() == null) {
            cliente.setClienteIDMYAV((long) (clientes.size() + 1));
            clientes.add(cliente);
        } else {
            clientes.removeIf(c -> c.getClienteIDMYAV().equals(cliente.getClienteIDMYAV()));
            clientes.add(cliente);
        }
        return cliente;
    }
    public ClienteMYAV actualizarmyav(ClienteMYAV cliente) {
        for (int i = 0; i < clientes.size(); i++) {
            ClienteMYAV c = clientes.get(i);
            if (c.getClienteIDMYAV().equals(cliente.getClienteIDMYAV())) {
                clientes.set(i, cliente);
                return cliente;
            }
        }
        return null;
    }
    public void deleteById(Long id) {
        clientes.removeIf(cliente -> cliente.getClienteIDMYAV().equals(id));
    }
}
