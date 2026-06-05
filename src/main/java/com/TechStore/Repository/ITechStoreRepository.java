package com.TechStore.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.TechStore.models.TechStore;

public interface ITechStoreRepository extends JpaRepository<TechStore, Integer> {

    List<TechStore> findByActivo(boolean activo);
    
    
    List<TechStore> findByDestacadoAndActivoOrderByIdDesc(int destacado, boolean activo);
    
    List<TechStore> findByPrecioBetween(double precioMin, double precioMax);
    
    List<TechStore> findByActivoIn(List<Boolean> estados);
}