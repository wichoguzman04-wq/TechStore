package com.TechStore.Services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TechStore.models.Categoria;
import com.TechStore.Repository.CategoriaRepository; 

@Service
public class CategoriaServiceImpl implements ICategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepo;

    @Override
    public List<Categoria> buscarTodas() {
        return categoriaRepo.findAll(); 
    }

    @Override
    public Categoria buscarPorId(Integer idCategoria) {
        return categoriaRepo.findById(idCategoria).orElse(null);
    }

    @Override
    public void guardar(Categoria categoria) {
        categoriaRepo.save(categoria); 
    }

    @Override
    public void eliminar(Integer idCategoria) {
        categoriaRepo.deleteById(idCategoria);
    }
}