package ar.edu.utn.frc.tup.lciii.dtos.Inscripcion;

import ar.edu.utn.frc.tup.lciii.dtos.AlumnoDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class InscripcionDto extends AlumnoDto {
    private List<String> materias;
}
