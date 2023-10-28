package com.rorozco.intecap.tarea3.apiresttienda.model.dao;

import com.rorozco.intecap.tarea3.apiresttienda.model.Fabricante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFabricanteDao extends JpaRepository<Fabricante,Integer> {
}
