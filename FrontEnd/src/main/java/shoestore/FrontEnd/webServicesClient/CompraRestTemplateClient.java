package shoestore.FrontEnd.webServicesClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import shoestore.FrontEnd.Dtos.CompraDetalleDto;

import java.util.Arrays;
import java.util.List;

@Service
public class CompraRestTemplateClient {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${api.tenis.base-url:http://localhost:8010}")
    private String base;

    public CompraDetalleDto comprarTenis(
            int idTenis,
            int idCliente,
            int idSucursal,
            int talla,
            int cantidad) {

        String url = base + "/api/compras/comprar"
                + "?idTenis=" + idTenis
                + "&idCliente=" + idCliente
                + "&idSucursal=" + idSucursal
                + "&talla=" + talla
                + "&cantidad=" + cantidad;

        return restTemplate.postForObject(url, null, CompraDetalleDto.class);
    }

    public List<CompraDetalleDto> obtenerCompras() {

        String url = base + "/api/compras/listar";

        CompraDetalleDto[] response = restTemplate.getForObject(url, CompraDetalleDto[].class);

        if (response == null) {
            return List.of();
        }

        return Arrays.asList(response);
    }

    public void eliminarCompra(int idCompra) {

        String url = base + "/api/compras/eliminar?idCompra=" + idCompra;

        restTemplate.delete(url);
    }
}
