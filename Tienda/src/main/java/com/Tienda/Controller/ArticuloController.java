
package com.Tienda.Controller;

import com.Tienda.domain.Articulo;
import com.Tienda.service.ArticuloService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ArticuloController {
    @Autowired 
  private ArticuloService articuloService;
    @RequestMapping("/articulo/listado")
    public String inicio(Model model) {
    List<Articulo> listaArticulos=articuloService.getAllArticulos(false);
    model.addAttribute("articulos", listaArticulos);
    return "/articulo/listado";
    }
     @GetMapping("/articulo/nuevo")
    public String nuevoArticulo(Articulo articulo){
    return "/articulo/modificar";
    }
    @PostMapping("/articulo/guardar")
    public String guardarArticulo(Articulo articulo){
        articuloService.save(articulo);
    return "redirect:/articulo/listado";
    }
    @GetMapping("/articulo/modificar/{idArticulo}")
    public String modificarArticulo(Articulo articulo,Model model){
    articulo= articuloService.getArticulo(articulo);
    model.addAttribute("articulo", articulo);
    return "/articulo/modificar";
    }
    
    @GetMapping("/articulo/eliminar/{idArticulo}")
    public String eliminarArticulo(Articulo articulo){
    articuloService.delete(articulo);
    return "redirect:/articulo/listado";
    }
    
}
