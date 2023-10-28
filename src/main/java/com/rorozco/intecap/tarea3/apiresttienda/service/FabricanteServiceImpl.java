package com.rorozco.intecap.tarea3.apiresttienda.service;

import com.rorozco.intecap.tarea3.apiresttienda.model.Fabricante;
import com.rorozco.intecap.tarea3.apiresttienda.model.dao.IFabricanteDao;
import com.rorozco.intecap.tarea3.apiresttienda.response.ResponseRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service //anotación para definirlo como servicio
public class FabricanteServiceImpl implements IFabricanteService {

    private static final Logger log = Logger.getLogger(FabricanteServiceImpl.class.getName());

    @Autowired  //anotación que inyecta el repositorio de FabricanteDao
    private IFabricanteDao fabricanteDao;  //variable para acceder a los metodos de la interface IFabricanteDao

    @Override
    @Transactional(readOnly = true) //anotación para indicar que es un metodo de solo lectura
    public ResponseEntity<ResponseRest<Fabricante>> buscarFabricantes() {
        log.info("inicio metodo buscarFabricantes");
        ResponseRest<Fabricante> response = new ResponseRest<Fabricante>();  //creación de un objeto de tipo ResponseRest<T>

        try {
            //creación de una lista de fabricantes para almacenar los fabricantes que se obtengan de la base de datos
            List<Fabricante> listFabricantes = (List<Fabricante>) fabricanteDao.findAll();
            //se asigna la lista de fabricantes al objeto de tipo ResponseRest
            response.setData(listFabricantes);
            //se asigna el mensaje de respuesta al objeto de tipo ResponseRest
            response.setMetadata("satisfactorio", "200", "Lista de Fabricantes");
        } catch (Exception e) {
            //se muestra un mensaje de error en caso de que ocurra una excepción
            log.severe("Error en el metodo buscarLibros: " + e.getMessage());
            e.getStackTrace();
            //se asigna el mensaje de respuesta al objeto de tipo ResponseRest
            response.setMetadata("Respuesta no exitosa", "500", "Error al consultar la lista de fabricantes");
            //se retorna un objeto de tipo ResponseEntity con el objeto de tipo ResponseRest<Fabricante> y el código de estado 500
            return new ResponseEntity<ResponseRest<Fabricante>>(response, HttpStatus.INTERNAL_SERVER_ERROR);

        }
        //se retorna un objeto de tipo ResponseEntity con el objeto de tipo ResponseRest<Fabricante> y el código de estado 200
        return new ResponseEntity<ResponseRest<Fabricante>>(response, HttpStatus.OK);
    }

    @Override
    @Transactional(readOnly = true) //anotación para indicar que es un método de solo lectura
    public ResponseEntity<ResponseRest<Fabricante>> buscarFabricantePorId(Integer id) {
        log.info("inicio método buscarFabricantePorId");

        ResponseRest<Fabricante> response = new ResponseRest<Fabricante>(); //creación de un objeto de tipo ResponseRest<Fabricante>
        List<Fabricante> list = new ArrayList<>();

        try {
            Optional<Fabricante> fabricante = fabricanteDao.findById(id); //se busca un fabricante por su id
            if (fabricante.isPresent()) {
                list.add(fabricante.get()); //se agrega el fabricante a la lista
                response.setData(list); //se asigna la lista de fabricantes al objeto de tipo ResponseRest
                response.setMetadata("Respuesta exitosa", "200", "Fabricante encontrado"); //se asigna el mensaje de respuesta al objeto de tipo ResponseRest<Fabricante>
            } else {
                log.severe("No se encontró el fabricante con el Id: " + id); //se muestra un mensaje de error en caso de que no se encuentre el fabricante
                response.setMetadata("Respuesta no exitosa", "404", "No se encontró el fabricante con el Id: " + id); //se asigna el mensaje de respuesta al objeto de tipo ResponseRest<Fabricante>
                return new ResponseEntity<ResponseRest<Fabricante>>(response, HttpStatus.NOT_FOUND); //se retorna un objeto de tipo ResponseEntity con el objeto de tipo ResponseRest<Fabricante> y el código de estado 404
            }
        } catch (Exception e) {
            log.severe("Error al buscar el fabricante : " + e.getMessage());
            e.getStackTrace();
            response.setMetadata("Error al buscar el fabricante", "500", "Error al consultar el fabricante"); //se asigna el mensaje de respuesta al objeto de tipo ResponseRest<Fabricante>
            return new ResponseEntity<ResponseRest<Fabricante>>(response, HttpStatus.INTERNAL_SERVER_ERROR); //se retorna un objeto de tipo ResponseEntity con el objeto de tipo ResponseRest<Fabricante> y el código de estado 500
        }

        return new ResponseEntity<ResponseRest<Fabricante>>(response, HttpStatus.OK); //se retorna un objeto de tipo ResponseEntity con el objeto de tipo ResponseRest<Fabricante> y el código de estado 200
    }

    @Override
    public ResponseEntity<ResponseRest<Fabricante>> crear(Fabricante fabricante) {
        return null;
    }

    @Override
    public ResponseEntity<ResponseRest<Fabricante>> actualizar(Fabricante fabricante, Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<ResponseRest<Fabricante>> eliminar(Integer id) {
        return null;
    }
}
