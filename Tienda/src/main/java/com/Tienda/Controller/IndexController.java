
package com.Tienda.Controller;

import com.Tienda.dao.ClienteDao;
import com.Tienda.domain.Cliente;
import com.Tienda.service.clienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class IndexController {
  @Autowired 
  private clienteService clienteService;
    @GetMapping("/")
    public String Inicio(Model model){
    List<Cliente> listaClientes=clienteService.getAllClientes();
    model.addAttribute("clientes", listaClientes);
    return "Clientes";
    }
   
}

