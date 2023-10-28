package com.rorozco.intecap.tarea3.apiresttienda.service;

import com.rorozco.intecap.tarea3.apiresttienda.model.Fabricante;
import com.rorozco.intecap.tarea3.apiresttienda.response.ResponseRest;
import org.springframework.http.ResponseEntity;

public interface IFabricanteService {
    /**
     * busca todos los fabricantes
     * @return ResponseEntity<ResponseRest<Fabricante>>
     */
    public ResponseEntity<ResponseRest<Fabricante>> buscarFabricantes();

    /**
     * busca fabricante por Id
     * @return ResponseEntity<ResponseRest<Fabricante>>
     */
    public ResponseEntity<ResponseRest<Fabricante>> buscarFabricantePorId(Integer id);

    /**
     * registra un nuevo fabricante
     * @return ResponseEntity<ResponseRest<Fabricante>>
     */
    public ResponseEntity<ResponseRest<Fabricante>> crear(Fabricante fabricante);

    /**
     * actualiza fabricante
     * @return ResponseEntity<ResponseRest<Fabricante>>
     */
    public ResponseEntity<ResponseRest<Fabricante>> actualizar(Fabricante fabricante, Integer id);

    /**
     * elimina fabricante
     * @return ResponseEntity<ResponseRest<Fabricante>>
     */
    public ResponseEntity<ResponseRest<Fabricante>> eliminar(Integer id);
}
