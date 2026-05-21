package shoestore.FrontEnd.Dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TenisDto {

    private Integer idTenis;
    private String marca;
    private String modelo;
    private double precio;
    private int stock;

    @Override
    public String toString() {

        return "TenisDto{" +
                "idTenis=" + idTenis +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", precio=" + precio +
                ", stock=" + stock +
                '}';
    }
}
