package com.example.backend.ii;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "INSCRIPCION")
public class INSCRIPCION {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_INSCRIPCION")
    private Integer IdInscripcion;

    @Column(name = "ID_ESTUDIANTE")
    private Integer IdEstudiante;

    @Column(name = "ID_CURSO")
    private Integer IdCurso;

    @Column(name = "FECHA_INSCRIPCION")
    private Date FechaInscripcion;

    public INSCRIPCION() {
    }

    public INSCRIPCION(Integer IdInscripcion, Integer IdEstudiante, Integer IdCurso, Date FechaInscripcion) {
        this.IdInscripcion = IdInscripcion;
        this.IdEstudiante = IdEstudiante;
        this.IdCurso = IdCurso;
        this.FechaInscripcion = FechaInscripcion;
    }

    public Integer getIdInscripcion() {
        return IdInscripcion;
    }

    public void setIdInscripcion(Integer IdInscripcion) {
        this.IdInscripcion = IdInscripcion;
    }

    public Integer getIdEstudiante() {
        return IdEstudiante;
    }

    public void setIdEstudiante(Integer IdEstudiante) {
        this.IdEstudiante = IdEstudiante;
    }

    public Integer getIdCurso() {
        return IdCurso;
    }

    public void setIdCurso(Integer IdCurso) {
        this.IdCurso = IdCurso;
    }

    public Date getFechaInscripcion() {
        return FechaInscripcion;
    }

    public void setFechaInscripcion(Date FechaInscripcion) {
        this.FechaInscripcion = FechaInscripcion;
    }
}
