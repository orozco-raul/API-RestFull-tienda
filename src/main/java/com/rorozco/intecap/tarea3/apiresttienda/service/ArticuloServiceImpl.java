package com.rorozco.intecap.tarea3.apiresttienda.service;

import com.rorozco.intecap.tarea3.apiresttienda.model.Articulo;
import com.rorozco.intecap.tarea3.apiresttienda.model.dao.IArticuloDao;
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
public class ArticuloServiceImpl  implements IArticuloService{

    private static final Logger log = Logger.getLogger(ArticuloServiceImpl.class.getName());

    @Autowired  //anotación que inyecta el repositorio de ArticuloDao
    private IArticuloDao articuloDao;  //variable para acceder a los metodos de la interface IArticuloDao

    @Override
    @Transactional(readOnly = true) //anotación para indicar que es un metodo de solo lectura
    public ResponseEntity<ResponseRest<Articulo>> buscarArticulos() {
        log.info("inicio metodo buscarArticulos");
        ResponseRest<Articulo> response = new ResponseRest<Articulo>();  //creación de un objeto de tipo ResponseRest<Articulo>

        try {
            //creación de una lista de artículos para almacenar los artículos que se obtengan de la base de datos
            List<Articulo> listArticulos = (List<Articulo>) articuloDao.findAll();
            //se asigna la lista de artículos al objeto de tipo ResponseRest
            response.setData(listArticulos);
            //se asigna el mensaje de respuesta al objeto de tipo ResponseRest
            response.setMetadata("satisfactorio", "200", "Lista de Artículos");
        } catch (Exception e) {
            //se muestra un mensaje de error en caso de que ocurra una excepción
            log.severe("Error en el metodo buscarArticulos: " + e.getMessage());
            e.getStackTrace();
            //se asigna el mensaje de respuesta al objeto de tipo ResponseRest
            response.setMetadata("Respuesta no exitosa", "500", "Error al consultar la lista de articulos");
            //se retorna un objeto de tipo ResponseEntity con el objeto de tipo ResponseRest<Articulo> y el código de estado 500
            return new ResponseEntity<ResponseRest<Articulo>>(response, HttpStatus.INTERNAL_SERVER_ERROR);

        }
        //se retorna un objeto de tipo ResponseEntity con el objeto de tipo ResponseRest<Articulo> y el código de estado 200
        return new ResponseEntity<ResponseRest<Articulo>>(response, HttpStatus.OK);
    }

    @Override
    @Transactional(readOnly = true) //anotación para indicar que es un método de solo lectura
    public ResponseEntity<ResponseRest<Articulo>> buscarArticuloPorId(Integer id) {
        log.info("inicio método buscarArticuloPorId");

        ResponseRest<Articulo> response = new ResponseRest<Articulo>(); //creación de un objeto de tipo ResponseRest<Articulo>
        List<Articulo> list = new ArrayList<>();

        try {
            Optional<Articulo> articulo = articuloDao.findById(id); //se busca un artículo por su id
            if (articulo.isPresent()) {
                list.add(articulo.get()); //se agrega el artículo a la lista
                response.setData(list); //se asigna la lista de artículos al objeto de tipo ResponseRest
                response.setMetadata("Respuesta exitosa", "200", "Artículo encontrado"); //se asigna el mensaje de respuesta al objeto de tipo ResponseRest<Articulo>
            } else {
                log.severe("No se encontró el artículo con el Id: " + id); //se muestra un mensaje de error en caso de que no se encuentre el artículo
                response.setMetadata("Respuesta no exitosa", "404", "No se encontró el artículo con el Id: " + id); //se asigna el mensaje de respuesta al objeto de tipo ResponseRest<Articulo>
                return new ResponseEntity<ResponseRest<Articulo>>(response, HttpStatus.NOT_FOUND); //se retorna un objeto de tipo ResponseEntity con el objeto de tipo ResponseRest<Articulo> y el código de estado 404
            }
        } catch (Exception e) {
            log.severe("Error al buscar el artículo : " + e.getMessage());
            e.getStackTrace();
            response.setMetadata("Error al buscar el artículo", "500", "Error al consultar el artículo"); //se asigna el mensaje de respuesta
            return new ResponseEntity<ResponseRest<Articulo>>(response, HttpStatus.INTERNAL_SERVER_ERROR); //se retorna un objeto de tipo ResponseEntity con el objeto de tipo ResponseRest<Articulo> y el código de estado 500
        }

        return new ResponseEntity<ResponseRest<Articulo>>(response, HttpStatus.OK); //se retorna un objeto de tipo ResponseEntity con el objeto de tipo ResponseRest<Articulo> y el código de estado 200
    }

    @Override
    public ResponseEntity<ResponseRest<Articulo>> crear(Articulo articulo) {
        return null;
    }

    @Override
    public ResponseEntity<ResponseRest<Articulo>> actualizar(Articulo articulo, Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<ResponseRest<Articulo>> eliminar(Integer id) {
        return null;
    }
}
