package shoestore.FrontEnd.Dtos;

import java.sql.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompraDetalleDto {
    private int idCompra;
    private int idCliente;
    private int idSucursal;
    private String fecha;

    private int idTenis;
    private int talla;
    private int cantidad;
    private float precioUnitario;

    @Override
    public String toString() {

        return "CompraDetalleDto{" +
                "idCompra=" + idCompra +
                ", idCliente='" + idCliente + '\'' +
                ", idSucursal='" + idSucursal + '\'' +
                ", idTenis=" + idTenis +
                ", talla=" + talla +
                ", cantidad=" + cantidad +
                ", precioUnitario=" + precioUnitario +
                '}';
    }
}
