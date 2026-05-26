package shoestore.FrontEnd.Dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SucursalDto {
    private Integer idSucursal;
    private String nombre;
    private String ciudad;

    @Override
    public String toString() {

        return "SucursalDto{" +
                "idSucursal=" + idSucursal +
                ", nombre='" + nombre + '\'' +
                ", ciudad='" + ciudad + '\'' +
                '}';
    }
}
