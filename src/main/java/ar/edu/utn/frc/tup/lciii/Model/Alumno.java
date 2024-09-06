package ar.edu.utn.frc.tup.lciii.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Alumno {
    private String legajo;
    private String nombre;
    private List<MateriaAlumno> materias;
}
