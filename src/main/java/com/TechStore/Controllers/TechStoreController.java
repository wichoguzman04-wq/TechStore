package com.TechStore.Controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.TechStore.Services.ICategoriaService;
import com.TechStore.Services.ITechStoreService;
import com.TechStore.models.TechStore;

@Controller
@RequestMapping("/productos")
public class TechStoreController {

    @Autowired
    private ITechStoreService service;

    @Autowired
    private ICategoriaService categoriaService;

    @GetMapping("/index")
    public String mostrarIndex(Model model) {
        List<TechStore> lista = service.buscarTodo();
        model.addAttribute("productos", lista);
        return "tabla";
    }

    // Unificamos las rutas de creación: "/create" ahora también envía las categorías por seguridad
    @GetMapping("/create")
    public String crear(Model model) {
        model.addAttribute("techStore", new TechStore()); 
        model.addAttribute("categorias", categoriaService.buscarTodas()); // Envía categorías
        return "formProducto";
    }

    // SOLUCIÓN AL AMBIGUOUS MAPPING: Un solo método limpio para la ruta "/nuevo"
    @GetMapping("/nuevo") 
    public String mostrarFormulario(TechStore techStore, Model model) {
        // Alimenta el select dinámico en tu HTML con la información de tu Workbench
        model.addAttribute("categorias", categoriaService.buscarTodas()); 
        return "formProducto"; // Retorna tu plantilla oficial de formulario
    }

    @PostMapping("/save")
    public String guardar(TechStore producto, BindingResult result, RedirectAttributes attributes, Model model) {
        if (result.hasErrors()) {
            // Si el formulario falla por validación, debemos volver a cargar las categorías para que no se vacíe el select
            model.addAttribute("categorias", categoriaService.buscarTodas());
            return "formProducto";
        }
        service.guardar(producto);
        attributes.addFlashAttribute("msg", "¡Producto guardado con éxito!");
        return "redirect:/productos/index";
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
}