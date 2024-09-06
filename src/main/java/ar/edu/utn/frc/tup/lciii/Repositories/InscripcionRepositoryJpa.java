package ar.edu.utn.frc.tup.lciii.Repositories;

import ar.edu.utn.frc.tup.lciii.Entities.MateriaAlumnoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InscripcionRepositoryJpa extends JpaRepository<MateriaAlumnoEntity,Long> {
    List<MateriaAlumnoEntity> findAllByLegajo(String legajo);
}
