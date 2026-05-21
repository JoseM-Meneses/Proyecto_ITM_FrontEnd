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
    private RestTemplate restTemplate; //Permite hacer peticiones HTTP (getForObject, post, put, delete)

    //Definicion de URL como base
    @Value("${api.tenis.base-url:http://localhost:8010}")
    private String base;

    //Obtiene los tenis desde la API
    public List<TenisDto> obtenerTenis() {
        String url = base + "/api/tenis/inventario"; //Construye la url completa
        //Hace el get a la API con getForObject y el Rest convierte el JSON a un arreglo
        TenisDto[] response = restTemplate.getForObject(url, TenisDto[].class);
        return Arrays.asList(response); //Devuelve los tenis como lista (List<TenisDto>)
    }

    public String agregarTenis(String marca, String modelo, double precio, int stock) {
        String url = base + "/api/tenis/agregar"
                + "?marca=" + marca
                + "&modelo=" + modelo
                + "&precio=" + precio
                + "&stock=" + stock; //Url completa con los parametros dados

        //Convierte la repuesta de la API al hacer el POST en un String
        return restTemplate.postForObject(url, null, String.class); //Devuelve un mensaje
        //Url -> A donde / null -> boddy / String -> a que debe convertirse
    }

    public void actualizarTenis(int id, double precio, int stock) {
        String url = base + "/api/tenis/actualizar"
                + "?id_tenis=" + id
                + "&precio=" + precio
                + "&stock=" + stock;

        //Hace la peticion PUT a la API
        restTemplate.put(url, null); //Actualiza los tenis - No devuelve nada
    }

    public void eliminarTenis(int id) {
        String url = base + "/api/tenis/eliminar?idTenis=" + id;
        //Hace la peticion DELETE a la API
        restTemplate.delete(url);
    }

    public int totalTenis() {
        String url = base + "/api/tenis/total";
        //Hace la peticion GET, devuleve numero
        return restTemplate.getForObject(url, Integer.class);
    }
}
