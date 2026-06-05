package com.TechStore.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/categorias")
public class CategoriaTechStore {
	
    @GetMapping("/index")
    public String mostrarIndex(Model model) {
        return "listCategoria";
    }

    @GetMapping("/create")
    public String crear() {
        return "formCategoria";
    }

    @PostMapping("/save")
    public String guardar(@RequestParam("nombre") String nombre, 
                          @RequestParam("descripcion") String descripcion) {
        
        System.out.println("Nombre Categoría: " + nombre);
        System.out.println("Descripción: " + descripcion);
        
        return "redirect:/categorias/index";
    }
}