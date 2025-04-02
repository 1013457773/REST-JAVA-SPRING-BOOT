package com.example.backend.ii;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "ASISTENCIAS")
public class ASISTENCIAS {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAsistencias")
    private Integer idAsistencia;

    @ManyToOne
    @JoinColumn(name = "FK_ESTUDIANTE", referencedColumnName = "ID_ESTUDIANTE")
    @JsonBackReference
    @Column(name = "idEstudiante")
    private Integer idEstudiante;

    @ManyToOne
    @JoinColumn(name = "FK_CURSO", referencedColumnName = "ID_CURSO")
    @JsonBackReference
    @Column(name = "idCurso")
    private Integer idCurso;

    @Column(name = "Fecha", nullable = false)
    private Date fFecha;

    @Column(name = "Estado", nullable = false , length = 50)
    private String Estado;


    public ASISTENCIAS() {
    }

    public ASISTENCIAS(Integer idAsistencias, Integer idEstudiante, Integer idCurso, Date Fecha, String Estado) {
        this.idAsistencia = idAsistencias;
        this.idEstudiante = idEstudiante;
        this.idCurso = idCurso;
        this.fFecha = Fecha;
        this.Estado = Estado;
    }

    public Integer getIdAsistencias() {
        return idAsistencia;
    }

    public void setIdAsistencia(Integer idAsistencias) {
        this.idAsistencia = idAsistencias;
    }

    public Integer getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Integer idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    public Date getFecha() {
        return fFecha;
    }

    public void setFecha(Date Fecha) {
        this.fFecha = Fecha;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
}
