package shoestore.FrontEnd.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import shoestore.FrontEnd.Dtos.TenisDto;
import shoestore.FrontEnd.webServicesClient.TenisRestTemplateClient;

import java.util.List;

@RestController
public class TenisController {

    @Autowired
    private TenisRestTemplateClient client;

    @GetMapping("/tenis-json")
    public List<TenisDto> getTenis(){

        //Obtener lista desde API REST
        List<TenisDto> tenis = client.obtenerTenis();

        //Mostrar consola
        for(TenisDto t : tenis){
            System.out.println(t);
        }

        //Retorna JSON
        return tenis;
    }

    @GetMapping("/stock-total")
    public int stockTotal(){
        return client.totalTenis();
    }

}
