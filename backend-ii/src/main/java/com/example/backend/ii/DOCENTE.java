package com.example.backend.ii;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "DOCENTE")
public class DOCENTE {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DOCENTE")
    private Integer IdDocente;

    @Column(name = "ID_USUARIO")
    private Integer IdUsuario;

    @Column(name = "ESPECIALIDAD", nullable = false, length = 100, unique = false)
    private String Especialidad;

    //creando relaciones (1 a muchos)
    @ManyToMany(mappedBy = "docente")
    @JsonManagedReference
    private List<CURSO> cursos;

    public DOCENTE() {
    }

    public DOCENTE(Integer IdDocente, Integer IdUsuario, String Especialidad) {
        this.IdDocente = IdDocente;
        this.IdUsuario = IdUsuario;
        this.Especialidad = Especialidad;
    }

    public Integer getIdDocente() {
        return IdDocente;
    }

    public void setIdDocente(Integer IdDocente) {
        this.IdDocente = IdDocente;
    }

    public Integer getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(Integer IdUsuario) {
        this.IdUsuario = IdUsuario;
    }

    public String getEspecialidad() {
        return Especialidad;
    }

    public void setEspecialidad(String Especialidad) {
        this.Especialidad = Especialidad;
    }
}
