package shoestore.FrontEnd.webServicesClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import shoestore.FrontEnd.Dtos.TenisDto;

import java.util.Arrays;
import java.util.List;

@Service
public class TenisRestTemplateClient {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${api.tenis.base-url:http://localhost:8010}")
    private String base;

    public List<TenisDto> obtenerTenis() {
        String url = base + "/api/tenis/inventario";
        TenisDto[] response = restTemplate.getForObject(url, TenisDto[].class);
        return Arrays.asList(response);
    }

    public String agregarTenis(String marca, String modelo, double precio, int stock) {
        String url = base + "/api/tenis/agregar"
                + "?marca=" + marca
                + "&modelo=" + modelo
                + "&precio=" + precio
                + "&stock=" + stock;

        return restTemplate.postForObject(url, null, String.class);
    }

    public void actualizarTenis(int id, double precio, int stock) {
        String url = base + "/api/tenis/actualizar"
                + "?id_tenis=" + id
                + "&precio=" + precio
                + "&stock=" + stock;

        restTemplate.put(url, null);
    }

    public void eliminarTenis(int id) {
        String url = base + "/api/tenis/eliminar?idTenis=" + id;
        restTemplate.delete(url);
    }

    public int totalTenis() {
        String url = base + "/api/tenis/total";
        return restTemplate.getForObject(url, Integer.class);
    }
}