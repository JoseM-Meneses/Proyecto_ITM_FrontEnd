package shoestore.FrontEnd.views;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import shoestore.FrontEnd.Dtos.SucursalDto;
import shoestore.FrontEnd.webServicesClient.SucursalRestTemplateClient;

@Controller
@RequestMapping("/sucursales")
public class SucursalViewController {

    @Autowired
    private SucursalRestTemplateClient client;

    @GetMapping
    public String mostrarFormulario(Model model){

        model.addAttribute("listarSucursales", client.obtenerSucursales());
        model.addAttribute("sucursalDto", new SucursalDto());

        return "sucursales";
    }

    @PostMapping("/guardar")
    public String guardarSucursal(
            @ModelAttribute("sucursalDto") SucursalDto sucursalDto, Model model){

        client.guardarSucursal(
                sucursalDto.getNombre(),
                sucursalDto.getCiudad()
        );

        model.addAttribute("sucursalRegistrada", sucursalDto);

        return "confirmacionSucursales";
    }

    @PostMapping("/actualizar")
    public String actualizarSucursal(
            @RequestParam int id,
            @RequestParam String nombre,
            @RequestParam String ciudad){

        client.actualizarSucursal(id, nombre, ciudad);

        return "redirect:/sucursales";
    }

    @PostMapping("/eliminar")
    public String eliminarSucursal(@RequestParam int id){

        client.eliminarSucursal(id);

        return "redirect:/sucursales";
    }
}
