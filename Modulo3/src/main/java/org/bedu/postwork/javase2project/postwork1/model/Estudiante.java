package org.bedu.postwork.javase2project.postwork1.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "estudiantes")
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String nombreCompleto;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Estudiante)) return false;
        Estudiante that = (Estudiante) o;
        return getId().equals(that.getId()) && getNombreCompleto().equals(that.getNombreCompleto());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNombreCompleto());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
}
