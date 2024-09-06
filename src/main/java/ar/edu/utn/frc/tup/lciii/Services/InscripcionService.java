package ar.edu.utn.frc.tup.lciii.Services;

import ar.edu.utn.frc.tup.lciii.dtos.Inscripcion.ConfirmacionInscDto;
import ar.edu.utn.frc.tup.lciii.dtos.Inscripcion.InscripcionDto;

public interface InscripcionService {
    ConfirmacionInscDto inscribirAlumno(InscripcionDto inscripcion);
}
