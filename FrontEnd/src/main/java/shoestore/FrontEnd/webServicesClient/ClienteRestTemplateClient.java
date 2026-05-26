package shoestore.FrontEnd.webServicesClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import shoestore.FrontEnd.Dtos.ClienteDto;

import java.util.Arrays;
import java.util.List;

@Service
public class ClienteRestTemplateClient {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${api.tenis.base-url:http://localhost:8010}")
    private String base;

    public List<ClienteDto> obtenerClientes() {
        String url = base + "/api/clientes/listar";
        ClienteDto[] response = restTemplate.getForObject(url, ClienteDto[].class);
        return Arrays.asList(response);
    }

    public String guardarCliente(String nombre, String correo, String telefono) {
        String url = base + "/api/clientes/agregar"
                + "?nombre=" + nombre
                + "&correo=" + correo
                + "&telefono=" + telefono;

        return restTemplate.postForObject(url, null, String.class);
    }

    public void actualizarCliente(int idCliente, String correo, String telefono) {
        String url = base + "/api/clientes/actualizar"
                + "?id_cliente=" + idCliente
                + "&correo=" + correo
                + "&telefono=" + telefono;

        restTemplate.put(url, null);
    }

    public void eliminarCliente(int idCliente) {
        String url = base + "/api/clientes/eliminar?id_cliente=" + idCliente;
        restTemplate.delete(url);
    }

}
