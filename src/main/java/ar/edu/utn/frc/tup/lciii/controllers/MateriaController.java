package ar.edu.utn.frc.tup.lciii.controllers;

import ar.edu.utn.frc.tup.lciii.Services.MateriaService;
import ar.edu.utn.frc.tup.lciii.dtos.Inscripcion.ConfirmacionInscDto;
import ar.edu.utn.frc.tup.lciii.dtos.Inscripcion.InscripcionDto;
import ar.edu.utn.frc.tup.lciii.dtos.MateriaDto;
import ar.edu.utn.frc.tup.lciii.dtos.MateriasDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MateriaController {
    @Autowired
    private MateriaService materiaService;

    @PostMapping("/gestion/materias")
    public ResponseEntity<MateriasDto> postMateria(@RequestBody MateriaDto materia){
        return new ResponseEntity<>(materiaService.saveMateria(materia), HttpStatus.CREATED);
    }
    @PostMapping("/gestion")
    public ResponseEntity<ConfirmacionInscDto> inscripcionMateria(@RequestBody InscripcionDto inscripcion){
        return new ResponseEntity<>(new ConfirmacionInscDto(),HttpStatus.OK);
    }
}
