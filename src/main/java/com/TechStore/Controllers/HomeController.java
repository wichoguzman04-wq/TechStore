package com.TechStore.Controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.TechStore.Services.ITechStoreService;
import com.TechStore.Services.ICategoriaService;
import com.TechStore.models.TechStore;

@Controller
public class HomeController {

    @Autowired
    private ITechStoreService service;

    @Autowired
    private ICategoriaService categoriaService;

    @GetMapping("/")
    public String mostrarHome(Model model) {
        List<TechStore> lista = service.buscarTodo();
        model.addAttribute("productos", lista);

        model.addAttribute("listaCategorias", categoriaService.buscarTodas());
        
        return "home";
    }

    @GetMapping("/tabla")
    public String mostrarTabla(Model model) {
        List<TechStore> lista = service.buscarTodo();
        model.addAttribute("productos", lista);
        return "tabla";
    }

    @GetMapping("/detalle/{id}")
    public String mostrarDetalle(@PathVariable("id") int id, Model model) {
        TechStore producto = service.buscarPorId(id); 
        model.addAttribute("producto", producto);
        return "detalle"; 
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarProducto(@PathVariable("id") int id, Model model) {
        model.addAttribute("mensaje", "El producto con ID " + id + " ha sido eliminado");
        return "mensaje";
    }

    @GetMapping("/mensaje")
    public String mostrarMensaje() {
        return "mensaje";
    }


}