package com.rorozco.intecap.tarea3.apiresttienda.service;

import com.rorozco.intecap.tarea3.apiresttienda.model.Articulo;
import com.rorozco.intecap.tarea3.apiresttienda.response.ResponseRest;
import org.springframework.http.ResponseEntity;

public interface IArticuloService {

    /**
     * busca todos los artículos
     * @return ResponseEntity<ResponseRest<Articulo>>
     */
    public ResponseEntity<ResponseRest<Articulo>> buscarArticulos();

    /**
     * busca artículo por Id
     * @return ResponseEntity<ResponseRest<Articulo>>
     */
    public ResponseEntity<ResponseRest<Articulo>> buscarArticuloPorId(Integer id);

    /**
     * registra un nuevo artículo
     * @return ResponseEntity<ResponseRest<Articulo>>
     */
    public ResponseEntity<ResponseRest<Articulo>> crear(Articulo articulo);

    /**
     * actualiza artículo
     * @return ResponseEntity<ResponseRest<Articulo>>
     */
    public ResponseEntity<ResponseRest<Articulo>> actualizar(Articulo articulo, Integer id);

    /**
     * elimina artículo
     * @return ResponseEntity<ResponseRest<Articulo>>
     */
    public ResponseEntity<ResponseRest<Articulo>> eliminar(Integer id);
}
