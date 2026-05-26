package shoestore.FrontEnd.views;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import shoestore.FrontEnd.Dtos.CompraDetalleDto;
import shoestore.FrontEnd.webServicesClient.CompraRestTemplateClient;

@Controller
@RequestMapping("/compras")
public class CompraViewController {

    @Autowired
    private CompraRestTemplateClient client;

    @GetMapping
    public String mostrarCompras(Model model){

        model.addAttribute("listaCompras", client.obtenerCompras());
        model.addAttribute("compraDto", new CompraDetalleDto());

        return "compras";
    }

    @PostMapping("/guardar")
    public String guardarCompra(
            @ModelAttribute("compraDto")
            CompraDetalleDto compraDto,

            Model model){

        try {

            CompraDetalleDto compraRegistrada =
                    client.comprarTenis(
                            compraDto.getIdTenis(),
                            compraDto.getIdCliente(),
                            compraDto.getIdSucursal(),
                            compraDto.getTalla(),
                            compraDto.getCantidad()
                    );

            if (compraRegistrada == null) {

                model.addAttribute(
                        "mensajeError",
                        "No se pudo realizar la compra"
                );

                return "errorCompra";
            }

            model.addAttribute(
                    "compraRegistrada",
                    compraRegistrada
            );

            return "confirmacionCompra";

        } catch (Exception e) {

            model.addAttribute(
                    "mensajeError",
                    "Error: Stock insuficiente o datos inválidos"
            );

            return "errorCompra";
        }
    }

    @PostMapping("/eliminar")
    public String eliminarCompra(@RequestParam int idCompra){

        client.eliminarCompra(idCompra);

        return "redirect:/compras";
    }
}
