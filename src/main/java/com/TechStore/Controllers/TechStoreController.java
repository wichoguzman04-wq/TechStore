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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.TechStore.Services.ITechStoreService;
import com.TechStore.models.TechStore;

@Controller
@RequestMapping("/productos")
public class TechStoreController {

    @Autowired
    private ITechStoreService service;

    @GetMapping("/delete")
    public String eliminar(@RequestParam("id") int id, RedirectAttributes attributes) {
        System.out.println("Eliminando producto con id: " + id);
        
        // Ejecuta la eliminación a través del servicio
        service.eliminar(id);
        
        // Configura el mensaje para la alerta verde en tu HTML
        attributes.addFlashAttribute("msg", "¡Producto eliminado del inventario con éxito!");
        
        // Redirige a la vista del inventario
        return "redirect:/productos/index";
    }

    @GetMapping("/view/{id}")
    public String verDetalle(@PathVariable("id") int id, Model model) {
        TechStore producto = service.buscarPorId(id);
        model.addAttribute("producto", producto);
        return "detalle";
    }

    @GetMapping("/create")
    public String crear(TechStore producto) { 
        return "formProducto";
    }
    
    @PostMapping("/save")
    public String guardar(TechStore producto, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            return "formProducto";
        }
        
        service.guardar(producto);
        
        attributes.addFlashAttribute("msg", "¡Producto guardado con éxito!");
        return "redirect:/productos/index";
    }

    @GetMapping("/index")
    public String mostrarIndex(Model model) {
        List<TechStore> lista = service.buscarTodo(); 
        model.addAttribute("productos", lista); 
        return "listado"; 
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
}