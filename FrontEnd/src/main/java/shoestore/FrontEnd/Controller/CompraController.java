package shoestore.FrontEnd.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import shoestore.FrontEnd.Dtos.ClienteDto;
import shoestore.FrontEnd.Dtos.CompraDetalleDto;
import shoestore.FrontEnd.webServicesClient.ClienteRestTemplateClient;
import shoestore.FrontEnd.webServicesClient.CompraRestTemplateClient;

import java.util.List;

@RestController
public class CompraController {

    @Autowired
    private CompraRestTemplateClient client;

    @GetMapping("/compra-json")
    public List<CompraDetalleDto> getCompra(){

        List<CompraDetalleDto> compras = client.obtenerCompras();

        for(CompraDetalleDto cr : compras){
            System.out.println(cr);
        }

        return compras;
    }
}
