package com.example.backend.ii;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "CALIFICACION")
public class CALIFICACION {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdCalificacion")
    private Integer IdCalificacion;

    @Column(name = "IdEstudiante")
    private Integer IdEstudiante;

    @Column(name = "IdMateria")
    private Integer IdMateria;

    @Column(name = "Nota", nullable = false, precision = 5, scale = 2)
    private Integer Nota;

    @Column(name = "FechaEvaluacion", nullable = false)
    private Date FechaEvaluacion;

    @ManyToOne
    @JoinColumn(name = "FK_docente", referencedColumnName = "ID_DOCENTE", nullable = false)
    @JsonBackReference
    private DOCENTE docente;

    public CALIFICACION() {
    }

    public CALIFICACION(Integer IdCalificacion, Integer IdEstudiante, Integer IdMateria, Integer Nota, Date FechaEvaluacion) {
        this.IdCalificacion = IdCalificacion;
        this.IdEstudiante = IdEstudiante;
        this.IdMateria = IdMateria;
        this.Nota = Nota;
        this.FechaEvaluacion = FechaEvaluacion;
    }

    public Integer getIdCalificacion() {

        return IdCalificacion;
    }

    public void setIdCalificacion(Integer IdCalificacion) {

        this.IdCalificacion = IdCalificacion;
    }

    public Integer getIdEstudiante() {

        return IdEstudiante;
    }

    public void setIdEstudiante(Integer IdEstudiante) {

        this.IdEstudiante = IdEstudiante;
    }

    public Integer getIdMateria() {

        return IdMateria;
    }

    public void setIdMateria(Integer IdMateria) {

        this.IdMateria = IdMateria;
    }

    public Integer getNota() {

        return Nota;
    }

    public void setNota(Integer Nota) {
        this.Nota = Nota;
    }

    public Date getFechaEvaluacion() {

        return FechaEvaluacion;
    }

    public void setFechaEvaluacion(Date FechaEvaluacion) {

        this.FechaEvaluacion = FechaEvaluacion;
    }
}
