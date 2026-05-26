package shoestore.FrontEnd.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import shoestore.FrontEnd.Dtos.SucursalDto;
import shoestore.FrontEnd.webServicesClient.SucursalRestTemplateClient;

import java.util.List;

@RestController
public class SucursalController {

    @Autowired
    private SucursalRestTemplateClient client;

    @GetMapping("/sucursal-json")
    public List<SucursalDto> getSucursales(){

        List<SucursalDto> sucursales = client.obtenerSucursales();

        for(SucursalDto s : sucursales){
            System.out.println(s);
        }

        return sucursales;
    }
}
