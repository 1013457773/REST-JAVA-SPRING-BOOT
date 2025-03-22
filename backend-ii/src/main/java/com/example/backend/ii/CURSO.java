package com.example.backend.ii;

import jakarta.persistence.*;

@Entity
@Table(name = "CUSRO")
public class CURSO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdCurso")
    private Integer IdCurso;

    @Column(name = "Nombre", nullable = false, length = 100)
    private String Nombre;

    @Column(name = "IdDocente")
    private Integer IdDocente;

    public CURSO() {
    }

    public CURSO(Integer IdCurso, String Nombre, Integer IdDocente) {
        this.IdCurso = IdCurso;
        this.Nombre = Nombre;
        this.IdDocente = IdDocente;
    }

    public Integer getIdCurso() {
        return IdCurso;
    }

    public void setIdCurso(Integer IdCurso) {
        this.IdCurso = IdCurso;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public Integer getIdDocente() {
        return IdDocente;
    }

    public void setIdDocente(Integer IdDocente) {
        this.IdDocente = IdDocente;
    }
}
