package com.TechStore.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.TechStore.Services.ICategoriaService;
import com.TechStore.models.Categoria;

@Controller
@RequestMapping("/categorias")
public class CategoriaTechStore {
    
    @Autowired
    private ICategoriaService service; 

    @GetMapping("/index")
    public String mostrarIndex(Model model) {
        model.addAttribute("categorias", service.buscarTodas());
        return "listCategoria";
    }

    @GetMapping("/create")
    public String crear(Model model) {
    	model.addAttribute("categoria", new Categoria());
        return "formCategoria";
    }

    @PostMapping("/save")
    public String guardar(Categoria categoria, RedirectAttributes attributes) {
        service.guardar(categoria);
        attributes.addFlashAttribute("msg", "¡Categoría guardada con éxito!");
        return "redirect:/categorias/index";
    }

    @GetMapping("/delete")
    public String eliminar(@RequestParam("id") Integer id, RedirectAttributes attributes) {
        service.eliminar(id);
        attributes.addFlashAttribute("msg", "Categoría eliminada correctamente.");
        return "redirect:/categorias/index";
    }
}