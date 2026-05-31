package com.TechStore.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.TechStore.models.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {

}