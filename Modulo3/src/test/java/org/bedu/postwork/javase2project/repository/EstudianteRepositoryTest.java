package org.bedu.postwork.javase2project.repository;


import org.bedu.postwork.javase2project.postwork1.model.Estudiante;
import org.bedu.postwork.javase2project.postwork1.repository.EstudianteRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ComponentScan(basePackages = "org.bedu.postwork.javase2project")
@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class EstudianteRepositoryTest {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @BeforeAll
    void cleanDatabase(){
        estudianteRepository.deleteAll();
    }




    @Test
    public void testSaveEstudiante(){
        Estudiante estudiante = new Estudiante();
        estudiante.setNombreCompleto("Juan Perez");
        estudianteRepository.save(estudiante);
    }

}