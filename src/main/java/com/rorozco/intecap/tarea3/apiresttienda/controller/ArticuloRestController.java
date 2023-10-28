package com.rorozco.intecap.tarea3.apiresttienda.controller;

import com.rorozco.intecap.tarea3.apiresttienda.model.Articulo;
import com.rorozco.intecap.tarea3.apiresttienda.model.Fabricante;
import com.rorozco.intecap.tarea3.apiresttienda.response.ResponseRest;
import com.rorozco.intecap.tarea3.apiresttienda.service.IArticuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1") // @RequestMapping: prefijo de la ruta de la API REST  http://localhost:8083/api/v1
public class ArticuloRestController {

    @Autowired // @Autowired: inyecta el servicio de articulos para poder utilizarlo dentro del controlador REST
    private IArticuloService articuloService; // IArticuloService: interface que contiene los metodos para acceder a los datos de la tabla articulo de la base de datos (CRUD)

    // @GetMapping: indica que este metodo se encarga de recibir las peticiones GET a la ruta /v1/articulos
    @GetMapping("/articulos") // localhost:8083/api/v1/articulos
    public ResponseEntity<ResponseRest<Articulo>> buscarArticulos() {
        return articuloService.buscarArticulos(); // Retornamos la respuesta al cliente
    }

    @GetMapping("/articulos/{id}")
    // @GetMapping: indica que este método se encarga de recibir las peticiones GET a la ruta /v1/articulos/{id}
    public ResponseEntity<ResponseRest<Articulo>> consultarPorId(@PathVariable Integer id) {  //  http://localhost:8083/api/v1/articulos/1
        return articuloService.buscarArticuloPorId(id);
    }
}
