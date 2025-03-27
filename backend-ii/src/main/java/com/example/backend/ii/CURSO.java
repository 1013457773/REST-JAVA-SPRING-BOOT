package com.example.backend.ii;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "CUSRO")
public class CURSO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdCurso")
    private Integer IdCurso;

    @Column(name = "Nombre", nullable = false, length = 100 , unique = false)
    private String Nombre;

    @Column(name = "IdDocente")
    private Integer IdDocente;

    //Creando relaciones de (Muchos a 1)
    @ManyToOne
    @JoinColumn(name = "FK_docente", referencedColumnName = "ID_DOCENTE")
    @JsonBackReference
    private  DOCENTE docente;

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
