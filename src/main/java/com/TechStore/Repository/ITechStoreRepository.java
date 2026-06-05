package com.TechStore.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.TechStore.models.TechStore;

public interface ITechStoreRepository extends JpaRepository<TechStore, Integer> {

    List<TechStore> findByActivo(boolean activo);
    
    List<TechStore> findByDestacadoAndActivoOrderByIdDesc(int destacado, boolean activo);
    
    List<TechStore> findByPrecioBetween(double precioMin, double precioMax);
    
    List<TechStore> findByActivoIn(List<Boolean> estados);

    @Query("SELECT p FROM TechStore p WHERE p.nombre LIKE %:texto% OR p.descripcion LIKE %:texto%")
    List<TechStore> buscarSoloTexto(@Param("texto") String texto);

    @Query("SELECT p FROM TechStore p WHERE (p.nombre LIKE %:texto% OR p.descripcion LIKE %:texto%) AND p.idCategoria = :categoria")
    List<TechStore> buscarTextoYCategoria(@Param("texto") String texto, @Param("categoria") Integer categoria);
}