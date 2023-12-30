package trabajoautonomomyav.ventasonlinemyav.ControladorMYAV;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trabajoautonomomyav.ventasonlinemyav.ModeloMYAV.ClienteMYAV;
import trabajoautonomomyav.ventasonlinemyav.ServicioMYAV.ClienteMYAVService;

import java.util.List;

@RestController
@RequestMapping("/clientesmyav")
public class ClienteControladorMYAV {
    @Autowired
    private ClienteMYAVService clienteService;

    @GetMapping
    public List<ClienteMYAV> getAllClientesmyav() {
        return clienteService.getAllClientesmyav();
    }

    @GetMapping("/{id}")
    public ClienteMYAV getClienteByIdmyav(@PathVariable Long id) {
        return clienteService.getClienteByIdmyav(id);
    }

    @PostMapping
    public ClienteMYAV guardarClientemyav(@RequestBody ClienteMYAV cliente) {return clienteService.guardarClientemyav(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteMYAV> actualizarCliente(@PathVariable Long id, @RequestBody ClienteMYAV cliente) {
        cliente.setClienteIDMYAV(id);
        ClienteMYAV clienteActualizado = clienteService.actualizarClientemyav(cliente);
        if (clienteActualizado != null) {
            return new ResponseEntity<>(clienteActualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void eliminarClientemyav(@PathVariable Long id) {
        clienteService.eliminarClientemyav(id);
    }
}
