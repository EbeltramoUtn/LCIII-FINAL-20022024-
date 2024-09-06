package ar.edu.utn.frc.tup.lciii.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Materias")
@Entity
public class MateriaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name = "Nombre",unique=true)
    private String nombre;
    @OneToMany(mappedBy = "materia",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MateriaAlumnoEntity> Matriculas;
}
