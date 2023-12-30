package trabajoautonomomyav.ventasonlinemyav.ModeloMYAV;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistroOrdenesMYAV {
    private Long ordenRIDMYAV;
    private ClienteMYAV clienteIDMYAV;
    private AlmacenMYAV almacenIDMYAV;
    private Double importeVentaMYAV;
    private LocalDate fecha;
    private LocalTime hora;
}
