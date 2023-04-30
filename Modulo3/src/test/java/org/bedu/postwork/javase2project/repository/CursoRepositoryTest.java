package org.bedu.postwork.javase2project.repository;


import org.bedu.postwork.javase2project.postwork1.model.Curso;
import org.bedu.postwork.javase2project.postwork1.model.Estudiante;
import org.bedu.postwork.javase2project.postwork1.model.Materia;
import org.bedu.postwork.javase2project.postwork1.repository.CursoRepository;
import org.bedu.postwork.javase2project.postwork1.repository.EstudianteRepository;
import org.bedu.postwork.javase2project.postwork1.repository.MateriaRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
@ComponentScan(basePackages = "org.bedu.postwork.javase2project")
@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CursoRepositoryTest {
    @Autowired
    private CursoRepository cursoRepository;
    @Autowired
    private EstudianteRepository estudianteRepository;
    @Autowired
    private MateriaRepository materiaRepository;

    @BeforeAll
    void cleanDatabase(){
        cursoRepository.deleteAll();
        materiaRepository.deleteAll();
        estudianteRepository.deleteAll();
    }

    @Test
    public void testCreaCurso(){
        Curso curso = new Curso();
        Materia materia = new Materia();
        materia.setNombre("Programación");
        materia = materiaRepository.save(materia);
        curso.setCiclo("uno");
        curso.setMateria(materia);
        Map<Estudiante,Integer> estudiantes = new HashMap<>();
        Estudiante estudiante = new Estudiante();
        estudiante.setNombreCompleto("Juan Perez");
        estudiante = estudianteRepository.save(estudiante);
        estudiantes.put(estudiante,estudiante.getId());
        curso.setCalificaciones(estudiantes);
        curso = cursoRepository.save(curso);
        System.out.println("fin");
    }

}