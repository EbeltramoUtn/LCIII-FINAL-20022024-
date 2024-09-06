package ar.edu.utn.frc.tup.lciii.Repositories;
import ar.edu.utn.frc.tup.lciii.Entities.MateriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MateriaRepositoryJpa extends JpaRepository<MateriaEntity, Long> {
    MateriaEntity findByNombre(String nombre);
}
