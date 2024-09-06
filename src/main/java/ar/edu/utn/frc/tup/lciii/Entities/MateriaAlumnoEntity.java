package ar.edu.utn.frc.tup.lciii.Entities;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ManyToAny;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Matriculas")
@Entity
public class MateriaAlumnoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name = "Alumno_Legajo")
    private String alumno;
    @Column(name = "calificacion")
    private Integer calificacion;
    @ManyToOne
    @JoinColumn(name = "Id_Materia", referencedColumnName = "Id")
    private MateriaEntity materia;
}
