package ar.edu.utn.frc.tup.lciii.Services.Impl;

import ar.edu.utn.frc.tup.lciii.Entities.MateriaEntity;
import ar.edu.utn.frc.tup.lciii.Exception.CustomException;
import ar.edu.utn.frc.tup.lciii.Model.Materia;
import ar.edu.utn.frc.tup.lciii.Repositories.MateriaRepositoryJpa;
import ar.edu.utn.frc.tup.lciii.Services.MateriaService;
import ar.edu.utn.frc.tup.lciii.dtos.MateriaDto;
import ar.edu.utn.frc.tup.lciii.dtos.MateriasDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.ArrayList;
import java.util.List;
@Service
public class MateriaServiceImpl implements MateriaService {
    private final MateriaRepositoryJpa materiaRepositoryJpa;
    private final ModelMapper modelMapper;;
    @Autowired
    public MateriaServiceImpl(MateriaRepositoryJpa materiaRepositoryJpa, ModelMapper modelMapper) {
        this.materiaRepositoryJpa = materiaRepositoryJpa;
        this.modelMapper = modelMapper;
    }
    @Override
    public MateriasDto saveMateria(MateriaDto materia) {
        MateriasDto result = new MateriasDto();
        if(getMateriaByNombre(materia.getMateria()) != null)
            throw new CustomException("La Materia ya existe", HttpStatus.CONFLICT);
        MateriaEntity materiaEntity = new MateriaEntity();
        materiaEntity.setNombre(materia.getMateria());
        materiaRepositoryJpa.save(materiaEntity);
        List<Materia> materias = getAllMaterias();
        for (Materia mat : materias) {
            result.getMaterias().add(mat.getNombre());
        }
        return result;

    }
    @Override
    public List<Materia> getAllMaterias(){
        List<MateriaEntity> entities = materiaRepositoryJpa.findAll();
        List<Materia> result = new ArrayList<>();
        for(MateriaEntity entity : entities){
            result.add(modelMapper.map(entity, Materia.class));
        }
        return result;
    }

    private MateriaDto getMateriaByNombre(String nombre){
        MateriaDto result = new MateriaDto();
        MateriaEntity materiaEntity =  materiaRepositoryJpa.findByNombre(nombre);
        if(materiaEntity == null){
            result = null;
        }else{
            result.setMateria(materiaEntity.getNombre());
        }
        return result;
    }
}
