package org.bedu.postwork.javase2project.repository;


import org.bedu.postwork.javase2project.postwork1.model.Materia;
import org.bedu.postwork.javase2project.postwork1.repository.MateriaRepository;
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
class MateriaRepositoryTest {
    @Autowired
    private MateriaRepository materiaRepository;

    @BeforeAll
    void cleanDatabase(){
        materiaRepository.deleteAll();
    }


    @Test
    public void testCreateMateria(){
        Materia materia = new Materia();
        materia.setNombre("Programación");
        materiaRepository.save(materia);
    }

}