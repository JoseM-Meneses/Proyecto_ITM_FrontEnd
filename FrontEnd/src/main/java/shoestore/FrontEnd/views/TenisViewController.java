package shoestore.FrontEnd.views;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import shoestore.FrontEnd.Dtos.TenisDto;
import shoestore.FrontEnd.webServicesClient.TenisRestTemplateClient;

@Controller
@RequestMapping("/tenis")
public class TenisViewController {

    @Autowired
    private TenisRestTemplateClient client;

    @GetMapping
    public String mostrarFormulario(Model model){

        model.addAttribute("listaTenis", client.obtenerTenis());
        model.addAttribute("stockTotal", client.totalTenis());
        model.addAttribute("tenisDto", new TenisDto());

        return "tenis";
    }

    @PostMapping("/guardar")
    public String guardarTenis(
            @ModelAttribute("tenisDto") TenisDto tenisDTO, Model model){

        client.agregarTenis(
                tenisDTO.getMarca(),
                tenisDTO.getModelo(),
                tenisDTO.getPrecio(),
                tenisDTO.getStock()
        );

        model.addAttribute("tenisRegistrado", tenisDTO);

        return "confirmacion";
    }

    @PostMapping("/actualizar")
    public String actualizarTenis(
            @RequestParam int id,
            @RequestParam double precio,
            @RequestParam int stock){

        client.actualizarTenis(id, precio, stock);

        return "redirect:/tenis";
    }

    @PostMapping("/eliminar")
    public String eliminarTenis(@RequestParam int id){

        client.eliminarTenis(id);

        return "redirect:/tenis";
    }

}
