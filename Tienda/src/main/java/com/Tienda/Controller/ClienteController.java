
package com.Tienda.Controller;

import com.Tienda.domain.Cliente;
import com.Tienda.service.clienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ClienteController {
    @Autowired 
  private clienteService clienteService;
    @RequestMapping("/cliente/listado")
    public String inicio(Model model) {
    List<Cliente> listaClientes=clienteService.getAllClientes();
    model.addAttribute("clientes", listaClientes);
    return "/cliente/listado";
    }
     @GetMapping("/cliente/nuevo")
    public String nuevoCliente(Cliente cliente){
    return "/cliente/modificar";
    }
    @PostMapping("/cliente/guardar")
    public String guardarCliente(Cliente cliente){
        clienteService.save(cliente);
    return "redirect:/cliente/listado";
    }
    @GetMapping("/cliente/modificar/{idCliente}")
    public String modificarCliente(Cliente cliente,Model model){
    cliente= clienteService.getCliente(cliente);
    model.addAttribute("cliente", cliente);
    return "/cliente/modificar";
    }
    
    @GetMapping("/cliente/eliminar/{idCliente}")
    public String eliminarCliente(Cliente cliente){
    clienteService.delete(cliente);
    return "redirect:/cliente/listado";
    }
    
}
