package shoestore.FrontEnd.Dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteDto {
    private Integer idCliente;
    private String nombre;
    private String correo;
    private String telefono;

    @Override
    public String toString() {

        return "ClientesDto{" +
                "idCliente=" + idCliente +
                ", nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", telefono=" + telefono +
                '}';
    }
}
