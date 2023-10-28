package com.rorozco.intecap.tarea3.apiresttienda.controller;

import com.rorozco.intecap.tarea3.apiresttienda.model.Fabricante;
import com.rorozco.intecap.tarea3.apiresttienda.response.ResponseRest;
import com.rorozco.intecap.tarea3.apiresttienda.service.IFabricanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1") // @RequestMapping: prefijo de la ruta de la API REST  http://localhost:8083/api/v1
public class FabricanteRestController {

    @Autowired // @Autowired: inyecta el servicio de fabricantes para poder utilizarlo dentro del controlador REST
    private IFabricanteService fabricanteService; // IFabricanteService: interface que contiene los metodos para acceder a los datos de la tabla fabricante de la base de datos (CRUD)

    // @GetMapping: indica que este metodo se encarga de recibir las peticiones GET a la ruta /v1/fabricantes
    @GetMapping("/fabricantes") // localhost:8083/api/v1/fabricantes
    public ResponseEntity<ResponseRest<Fabricante>> buscarFabricantes() {
        return fabricanteService.buscarFabricantes(); // Retornamos la respuesta al cliente
    }

    @GetMapping("/fabricantes/{id}")
    // @GetMapping: indica que este método se encarga de recibir las peticiones GET a la ruta /v1/fabricantes/{id}
    public ResponseEntity<ResponseRest<Fabricante>> consultarPorId(@PathVariable Integer id) {  //  http://localhost:8083/api/v1/fabricantes/1
        return fabricanteService.buscarFabricantePorId(id);
    }
}
