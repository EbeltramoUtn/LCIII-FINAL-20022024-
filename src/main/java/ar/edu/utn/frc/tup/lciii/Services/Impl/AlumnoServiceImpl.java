package ar.edu.utn.frc.tup.lciii.Services.Impl;

import ar.edu.utn.frc.tup.lciii.Model.Alumno;
import ar.edu.utn.frc.tup.lciii.Services.AlumnoService;
import org.springframework.stereotype.Service;

@Service
public class AlumnoServiceImpl implements AlumnoService {
    //TODO Implemtnear WebClient
    @Override
    public Alumno getAlumnoByLegajo(String legajo) {
        Alumno alumno = new Alumno();
        alumno.setNombre("Prueba");
        alumno.setLegajo(legajo);
        return null;
    }
}
