package com.rorozco.intecap.tarea3.apiresttienda.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity                     //anotación para definir una entidad
@Table(name = "articulo")   //nombre de la tabla en base de datos
public class Articulo implements Serializable {

    private static final long serialVersionUID=1L;  //identificador unico de la clase autogenerada

    @Id
    private Integer id;

    @Column(length = 30)
    private String nombre;

    private Double precio;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fabricante", nullable = false)
    @JsonBackReference
    private Fabricante fabricante;

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

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }
}
