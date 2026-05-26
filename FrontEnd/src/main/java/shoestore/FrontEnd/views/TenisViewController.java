
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

        //Consume con client. y guarda en "listaTenis" para usar en html
        model.addAttribute("listaTenis", client.obtenerTenis());

        //Total stock
        model.addAttribute("stockTotal", client.totalTenis());

        //DTO vacío para que trabaje el formulario
        model.addAttribute("tenisDto", new TenisDto());

        return "tenis";
    }

    @PostMapping("/guardar") //Se ejecuta con <form th:action="@{/tenis/guardar}">
    public String guardarTenis(
            //Spring llena automáticamente el DTO desde el formulario HTML con los inputs
            @ModelAttribute("tenisDto") TenisDto tenisDTO, Model model){

        //Consumir API
        client.agregarTenis(
                tenisDTO.getMarca(),
                tenisDTO.getModelo(),
                tenisDTO.getPrecio(),
                tenisDTO.getStock()
        );

        model.addAttribute("tenisRegistrado", tenisDTO);

        return "confirmacionTenis";
    }

    @PostMapping("/actualizar")
    public String actualizarTenis(
            @RequestParam int id,
            @RequestParam double precio,
            @RequestParam int stock){

        client.actualizarTenis(id, precio, stock);

        //Carga la tabla ya actualizada
        return "redirect:/tenis";
    }

    @PostMapping("/eliminar")
    public String eliminarTenis(@RequestParam int id){

        client.eliminarTenis(id);

        return "redirect:/tenis";
    }

}
