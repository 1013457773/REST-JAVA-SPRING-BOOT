package com.example.backend.modelos;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table (name ="docente")
public class Docente {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id_docente")
    private Integer IdDocente;
    @Column (name = "id_usuario")
   private Integer IdUsuario;
     @Column (name= "espacialidad", nullable = false, length = 100)
   private String Especialidad;

     // CREANDO RELACION 1 A MUCHOS
     @OneToMany (mappedBy = "docente")
     @JsonManagedReference
     private List<Curso> curso;


    public Docente() {
    }

    public Docente(Integer idDocente, Integer idUsuario, String especialidad) {
        IdDocente = idDocente;
        IdUsuario = idUsuario;
        Especialidad = especialidad;
    }

    public Integer getIdDocente() {
        return IdDocente;
    }

    public void setIdDocente(Integer idDocente) {
        IdDocente = idDocente;
    }

    public Integer getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        IdUsuario = idUsuario;
    }

    public String getEspecialidad() {
        return Especialidad;
    }

    public void setEspecialidad(String especialidad) {
        Especialidad = especialidad;
    }
}

