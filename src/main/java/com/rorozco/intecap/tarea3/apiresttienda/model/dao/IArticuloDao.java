package com.rorozco.intecap.tarea3.apiresttienda.model.dao;

import com.rorozco.intecap.tarea3.apiresttienda.model.Articulo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IArticuloDao extends JpaRepository<Articulo,Integer> {
}
