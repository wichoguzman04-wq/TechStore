package com.TechStore.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.TechStore.models.TechStore;

@Repository
public interface ITechStoreRepository extends JpaRepository<TechStore, Integer> {

    @Query("SELECT p FROM TechStore p WHERE p.destacado = :destacado AND p.categoria.activo = :activo ORDER BY p.id DESC")
    List<TechStore> findByDestacadoAndActivoOrderByIdDesc(@Param("destacado") Integer destacado, @Param("activo") boolean activo);

    // Si tienes el método simple de buscar por estatus, se mapea así:
    List<TechStore> findByEstatus(String estatus);
}