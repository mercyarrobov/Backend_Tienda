package trabajoautonomomyav.ventasonlinemyav.ControladorMYAV;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trabajoautonomomyav.ventasonlinemyav.ModeloMYAV.RegistroOrdenesMYAV;
import trabajoautonomomyav.ventasonlinemyav.ServicioMYAV.RegistroOrdenesMYAVService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/registrosordenesmyav")
public class RegistroOrdenesMYAVController {

    private final RegistroOrdenesMYAVService registroOrdenesMYAVService;

    @Autowired
    public RegistroOrdenesMYAVController(RegistroOrdenesMYAVService registroOrdenesMYAVService) {
        this.registroOrdenesMYAVService = registroOrdenesMYAVService;
    }

    @PostMapping
    public ResponseEntity<RegistroOrdenesMYAV>
    guardarRegistroOrdenes(@RequestBody RegistroOrdenesMYAV registroOrdenesMYAV) {
        RegistroOrdenesMYAV nuevoRegistro = registroOrdenesMYAVService.guardarRegistroOrdenes(registroOrdenesMYAV);
        return new ResponseEntity<>(nuevoRegistro, HttpStatus.CREATED);
    }
}
