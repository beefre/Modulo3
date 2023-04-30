package org.bedu.postwork.javase2project.postwork1.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "materias")
public class Materia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String nombre;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Materia)) return false;
        Materia materia = (Materia) o;
        return getId().equals(materia.getId()) && getNombre().equals(materia.getNombre());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNombre());
    }

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
