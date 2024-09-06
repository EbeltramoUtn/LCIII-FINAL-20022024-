package ar.edu.utn.frc.tup.lciii.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.internal.bytebuddy.pool.TypePool;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class MateriaAlumno extends Materia{
    private Integer calificacion;


    public String getEstado() {
        String estado = "";
        if(calificacion==null || calificacion==0){
            estado = "Pendiente";
        } else if (calificacion<4) {
            estado = "LIBRE";
        }else if (calificacion<9){
            estado = "REGULAR";
        }else{
            estado = "PROMOCIONADO";
        }
        return estado;
    }
}
