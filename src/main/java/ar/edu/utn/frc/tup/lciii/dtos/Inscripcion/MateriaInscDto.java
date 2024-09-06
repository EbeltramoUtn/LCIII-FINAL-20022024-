package ar.edu.utn.frc.tup.lciii.dtos.Inscripcion;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MateriaInscDto {
    private String materia;
    private Integer calificacion;
    private String estado;
}
