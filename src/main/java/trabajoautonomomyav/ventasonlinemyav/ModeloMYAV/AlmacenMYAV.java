package trabajoautonomomyav.ventasonlinemyav.ModeloMYAV;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlmacenMYAV {
    private Long almacenIDMYAV;
    private String nombreTiendaMYAV;
}
