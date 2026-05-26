package shoestore.FrontEnd.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import shoestore.FrontEnd.Dtos.ClienteDto;
import shoestore.FrontEnd.webServicesClient.ClienteRestTemplateClient;

import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    private ClienteRestTemplateClient client;

    @GetMapping("/cliente-json")
    public List<ClienteDto> getCliente(){

        List<ClienteDto> clientes = client.obtenerClientes();

        for(ClienteDto c : clientes){
            System.out.println(c);
        }

        return clientes;
    }

}
