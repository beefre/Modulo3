package org.bedu.postwork.javase2project.postwork1.model;



import javax.persistence.*;
import java.util.Map;
import java.util.Objects;

@Entity
@Table(name = "cursos")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "materias_fk", referencedColumnName = "id")
    private Materia materia;
    @Column
    private String ciclo;

    @ElementCollection
    @CollectionTable(name = "cursos_has_estudiantes", joinColumns = {@JoinColumn(name = "cursos_fk", referencedColumnName = "id")})
    //@CollectionTable(name = "cursos_has_estudiantes")
    //@MapKeyJoinColumn(name = "estudiantes_fk")
    @MapKeyJoinColumn(name = "estudiantes_fk", referencedColumnName = "id")
    @Column(name = "calificacion")
    private Map<Estudiante,Integer> calificaciones;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Curso)) return false;
        Curso curso = (Curso) o;
        return getId().equals(curso.getId()) && getMateria().equals(curso.getMateria()) && getCiclo().equals(curso.getCiclo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getMateria(), getCiclo());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public Map<Estudiante, Integer> getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(Map<Estudiante, Integer> calificaciones) {
        this.calificaciones = calificaciones;
    }
}
