package com.example.backend.ii;

import jakarta.persistence.*;

@Entity
@Table(name = "MATERIA")
public class MATERIA {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_MATERIA")
    private Integer IdMateria;

    @Column(name = "NOMBRE", nullable = false, length = 100)
    private String Nombre;

    @Column(name = "ID_CURSO")
    private Integer IdCurso;

    public MATERIA() {
    }

    public MATERIA(Integer IdMateria, String Nombre, Integer IdCurso) {
        this.IdMateria = IdMateria;
        this.Nombre = Nombre;
        this.IdCurso = IdCurso;
    }

    public Integer getIdMateria() {
        return IdMateria;
    }

    public void setIdMateria(Integer IdMateria) {
        this.IdMateria = IdMateria;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public Integer getIdCurso() {
        return IdCurso;
    }

    public void setIdCurso(Integer IdCurso) {
        this.IdCurso = IdCurso;
    }
}
