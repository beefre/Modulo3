package org.bedu.postwork.javase2project.postwork1.repository;


import org.bedu.postwork.javase2project.postwork1.model.Estudiante;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteRepository extends CrudRepository<Estudiante,Integer> {
}
