package ar.edu.utn.frc.tup.lciii.Services.Impl;

import ar.edu.utn.frc.tup.lciii.Entities.MateriaAlumnoEntity;
import ar.edu.utn.frc.tup.lciii.Exception.CustomException;
import ar.edu.utn.frc.tup.lciii.Model.Alumno;
import ar.edu.utn.frc.tup.lciii.Model.Materia;
import ar.edu.utn.frc.tup.lciii.Model.MateriaAlumno;
import ar.edu.utn.frc.tup.lciii.Repositories.InscripcionRepositoryJpa;
import ar.edu.utn.frc.tup.lciii.Repositories.MateriaRepositoryJpa;
import ar.edu.utn.frc.tup.lciii.Services.AlumnoService;
import ar.edu.utn.frc.tup.lciii.Services.InscripcionService;
import ar.edu.utn.frc.tup.lciii.Services.MateriaService;
import ar.edu.utn.frc.tup.lciii.dtos.Inscripcion.ConfirmacionInscDto;
import ar.edu.utn.frc.tup.lciii.dtos.Inscripcion.InscripcionDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class InscripcionServiceImpl implements InscripcionService {
    @Autowired
    private InscripcionRepositoryJpa inscripcionRepositoryJpa;
    @Autowired
    private MateriaService materiaService;
    @Autowired
    private AlumnoService alumnoService;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ConfirmacionInscDto inscribirAlumno(InscripcionDto inscripcion) {
        ConfirmacionInscDto result=new ConfirmacionInscDto();
        Alumno alumno = alumnoService.getAlumnoByLegajo(inscripcion.getLegajo());
        if(alumno==null)
            throw new CustomException("No se encontro alumno registrado con el legajo: "+inscripcion.getLegajo(), HttpStatus.NOT_FOUND);
        List<Materia> materias = materiaService.getAllMaterias();
        return null;
    }
    private Alumno getAlumnoByLegajo(String legajo){
        Alumno alumno = alumnoService.getAlumnoByLegajo(legajo);
        return alumno;
    }
    private List<MateriaAlumno> getInscripcionAlumno(Alumno alumno){
        List<MateriaAlumno> result=new ArrayList<>();
        List<MateriaAlumnoEntity> InscripcionesEntity = inscripcionRepositoryJpa.findAllByLegajo(alumno.getLegajo());
        for(MateriaAlumnoEntity m : InscripcionesEntity){
            result.add(modelMapper.map(m, MateriaAlumno.class));
        }
        return result;
    }

    /**
     * Valida que las materia que se quieran inscribir no figure inscripto
     * @param inscripto Listado de materias en las que ya esta inscripto
     * @param aInscribir Listado de materia que se va inscribir
     * @return TRUE si la inscripcion es valida.
     * FALSE si hay materias repetidas
     */
    private boolean validarInscripcion(List<MateriaAlumno> inscripto, List<Materia> aInscribir){
        //TODO Implement
    }
}
