package ar.edu.utn.frc.tup.lciii.Services;

import ar.edu.utn.frc.tup.lciii.Model.Materia;
import ar.edu.utn.frc.tup.lciii.dtos.MateriaDto;
import ar.edu.utn.frc.tup.lciii.dtos.MateriasDto;

import java.util.List;

public interface MateriaService {
    MateriasDto saveMateria(MateriaDto materia);
    List<Materia> getAllMaterias();
}
