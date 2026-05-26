package shoestore.FrontEnd.webServicesClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import shoestore.FrontEnd.Dtos.SucursalDto;

import java.util.Arrays;
import java.util.List;

@Service
public class SucursalRestTemplateClient {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${api.tenis.base-url:http://localhost:8010}")
    private String base;

    public List<SucursalDto> obtenerSucursales() {
        String url = base + "/api/sucursales/listar";
        SucursalDto[] response = restTemplate.getForObject(url, SucursalDto[].class);
        return Arrays.asList(response);
    }

    public String guardarSucursal(String nombre, String ciudad) {
        String url = base + "/api/sucursales/agregar"
                + "?nombre=" + nombre
                + "&ciudad=" + ciudad;

        return restTemplate.postForObject(url, null, String.class);
    }

    public void actualizarSucursal(int idSucursal, String nombre, String ciudad) {
        String url = base + "/api/sucursales/actualizar"
                + "?id_sucursal=" + idSucursal
                + "&nombre=" + nombre
                + "&ciudad=" + ciudad;

        restTemplate.put(url, null);
    }

    public void eliminarSucursal(int idSucursal) {
        String url = base + "/api/sucursales/eliminar?id_sucursal=" + idSucursal;
        restTemplate.delete(url);
    }
}
