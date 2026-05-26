package shoestore.FrontEnd.views;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import shoestore.FrontEnd.Dtos.ClienteDto;
import shoestore.FrontEnd.webServicesClient.ClienteRestTemplateClient;

@Controller
@RequestMapping("/clientes")
public class ClienteViewController {

    @Autowired
    private ClienteRestTemplateClient client;

    @GetMapping
    public String mostrarFormulario(Model model){

        model.addAttribute("listaClientes", client.obtenerClientes());
        model.addAttribute("clienteDto", new ClienteDto());

        return "clientes";
    }

    @PostMapping("/guardar")
    public String guardarCliente(
            @ModelAttribute("clienteDto") ClienteDto clienteDto, Model model){

        client.guardarCliente(
                clienteDto.getNombre(),
                clienteDto.getCorreo(),
                clienteDto.getTelefono()
        );

        model.addAttribute("clienteRegistrado", clienteDto);

        return "confirmacionClientes";
    }

    @PostMapping("/actualizar")
    public String actualizarCliente(
            @RequestParam int id,
            @RequestParam String correo,
            @RequestParam String telefono){

        client.actualizarCliente(id, correo, telefono);

        return "redirect:/clientes";
    }

    @PostMapping("/eliminar")
    public String eliminarCliente(@RequestParam int id){

        client.eliminarCliente(id);

        return "redirect:/clientes";
    }
}
