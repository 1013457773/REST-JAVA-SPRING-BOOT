package com.example.backend.modelos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.sql.Date;
@Entity
@Table (name ="calificacion")
public class Calificacion {
     @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id_calificacion")
    private Integer IdCalificacion;
    @Column (name = "id_estudiante")
    private Integer IdEstudiante;
    @Column (name = "id_materia")
    private Integer IdMateria;
    @Column (name = "nota", nullable = false, scale = 2, precision = 5 )
    private Integer  Nota;
    @Column (name= "fecha_evaluacion", nullable = false)
    private Date FechaEvaluacion;

    @ManyToOne
    @JoinColumn (name="fk_estudiante",referencedColumnName = "id_estudiante")
    @JsonBackReference
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn (name = "fk_materia",referencedColumnName = "id_materia")
    @JsonBackReference
    private Materia materia;


    public Calificacion() {
    }

    public Calificacion(Integer idCalificacion, Integer idEstudiante, Integer idMateria, Integer nota, Date fechaEvaluacion) {
        IdCalificacion = idCalificacion;
        IdEstudiante = idEstudiante;
        IdMateria = idMateria;
        Nota = nota;
        FechaEvaluacion = fechaEvaluacion;
    }

    public Integer getIdCalificacion() {
        return IdCalificacion;
    }

    public void setIdCalificacion(Integer idCalificacion) {
        IdCalificacion = idCalificacion;
    }

    public Integer getIdEstudiante() {
        return IdEstudiante;
    }

    public void setIdEstudiante(Integer idEstudiante) {
        IdEstudiante = idEstudiante;
    }

    public Integer getIdMateria() {
        return IdMateria;
    }

    public void setIdMateria(Integer idMateria) {
        IdMateria = idMateria;
    }

    public Integer getNota() {
        return Nota;
    }

    public void setNota(Integer nota) {
        Nota = nota;
    }

    public Date getFechaEvaluacion() {
        return FechaEvaluacion;
    }

    public void setFechaEvaluacion(Date fechaEvaluacion) {
        FechaEvaluacion = fechaEvaluacion;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }
}
