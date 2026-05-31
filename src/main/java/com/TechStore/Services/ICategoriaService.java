package com.TechStore.Services;

import java.util.List;

import com.TechStore.models.Categoria;

public interface ICategoriaService {
    
    List<Categoria> buscarTodas();
    Categoria buscarPorId(Integer idCategoria);
    void guardar(Categoria categoria);
    void eliminar(Integer idCategoria);
}