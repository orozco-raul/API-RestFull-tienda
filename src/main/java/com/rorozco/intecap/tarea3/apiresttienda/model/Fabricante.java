package com.rorozco.intecap.tarea3.apiresttienda.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity //anotación para definir una entidad
@Table(name="fabricante")   //nombre de la tabla en base de datos
public class Fabricante implements Serializable {

    private static final long serialVersionUID=1L;  //identificador unico de la clase autogenerada

    @Id
    private Integer id;

    @Column(length = 30)
    private String nombre;

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true,
            mappedBy = "fabricante"
    )
    @JsonManagedReference
    private Set<Articulo> articulos;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
