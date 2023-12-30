package trabajoautonomomyav.ventasonlinemyav.ModeloMYAV;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoMYAV {

    private Long productoIdMYAV;
    private RegistroOrdenesMYAV ordenRIDMYAV;
    private String nombreProductoMYAV;
    private Double precioMYAV;
}
