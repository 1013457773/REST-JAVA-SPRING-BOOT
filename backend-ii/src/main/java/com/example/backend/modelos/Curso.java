package com.example.backend.modelos;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table (name ="curso")
public class Curso {
     @Id
     @GeneratedValue (strategy = GenerationType.IDENTITY)
     @Column (name = "id_curso")
    private Integer IdCurso;
     @Column (name = "nombre", nullable = false, length = 100, unique = false)
    private String Nombre;
     @Column ( name = "id_docente")
    private Integer IdDoncete;


     // creando relacion de muchos a 1
    @ManyToOne
    @JoinColumn(name = "fk_docente", referencedColumnName = "id_docente")
    @JsonBackReference
    private Docente docente;

    @OneToOne (mappedBy = "curso")
    @JsonManagedReference
    private Inscripcion inscripcion;

    @OneToMany (mappedBy = "curso")
    @JsonManagedReference
    private List<Materia> materia;

    @OneToMany (mappedBy = "curso")
    @JsonManagedReference
    private List <Asistencia> asistencia;


    public Curso() {
    }

    public Curso(Integer idCurso, String nombre, Integer idDoncete) {
        IdCurso = idCurso;
        Nombre = nombre;
        IdDoncete = idDoncete;
    }

    public Integer getIdCurso() {
        return IdCurso;
    }

    public void setIdCurso(Integer idCurso) {
        IdCurso = idCurso;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public Integer getIdDoncete() {
        return IdDoncete;
    }

    public void setIdDoncete(Integer idDoncete) {
        IdDoncete = idDoncete;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public Inscripcion getInscripcion() {
        return inscripcion;
    }

    public void setInscripcion(Inscripcion inscripcion) {
        this.inscripcion = inscripcion;
    }

    public List<Materia> getMateria() {
        return materia;
    }

    public void setMateria(List<Materia> materia) {
        this.materia = materia;
    }

    public List<Asistencia> getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(List<Asistencia> asistencia) {
        this.asistencia = asistencia;
    }
}
