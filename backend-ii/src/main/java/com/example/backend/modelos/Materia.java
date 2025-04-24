package com.example.backend.modelos;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table (name ="materia")
public class Materia {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id_materia")
    private Integer IdMateria;
    @Column (name = "nombre", nullable = false, length = 100)
    private String Nombre;
    @Column (name = "id_curso")
    private Integer IdCurso;

    @ManyToOne
    @JoinColumn (name = "fk_curso", referencedColumnName = "id_curso")
    @JsonBackReference
    private Curso curso;

    @OneToMany (mappedBy = "materia")
    @JsonManagedReference
    private List<Calificacion>calificacion;

    public Materia() {

    }

    public Materia(Integer idMateria, String nombre, Integer idCurso) {
        IdMateria = idMateria;
        Nombre = nombre;
        IdCurso = idCurso;
    }

    public Integer getIdMateria() {
        return IdMateria;
    }

    public void setIdMateria(Integer idMateria) {
        IdMateria = idMateria;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public Integer getIdCurso() {
        return IdCurso;
    }

    public void setIdCurso(Integer idCurso) {
        IdCurso = idCurso;
    }
}

