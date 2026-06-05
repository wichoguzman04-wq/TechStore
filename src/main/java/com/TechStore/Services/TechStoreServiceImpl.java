package com.TechStore.Services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TechStore.Repository.ITechStoreRepository;
import com.TechStore.models.TechStore;

@Service
public class TechStoreServiceImpl implements ITechStoreService {

    @Autowired
    private ITechStoreRepository repository;

    @Override
    public List<TechStore> buscarTodo() {
        return (List<TechStore>) repository.findAll();
    }

    @Override
    public TechStore buscarPorId(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void guardar(TechStore producto) {
        repository.save(producto);
    }

    @Override
    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}