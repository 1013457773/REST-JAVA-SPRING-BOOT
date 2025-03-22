package com.example.backend.ii;

import jakarta.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "ESTUDIANTE")
public class Estudiamte{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ESTUDIANTE")
    private Integer IdEstudiante;

    @Column(name = "ID_USUARIO")
    private Integer IdUsuario;

    @Column(name = "GRADO", nullable = false)
    private Integer Grado;

    @Column(name = "FECHA_NACIMIENTO", nullable = false)
    private Date FechaNacimiento;

    @Column(name = "DIRECCION", nullable = false, length = 250)
    private String Direccion;

    public void ESTUDIANTE(){
    }

    public void ESTUDIANTE(Integer IdEstudiante, Integer IdUsuario, Integer Grado, Date FechaNacimiento, String Direccion) {
        this.IdEstudiante = IdEstudiante;
        this.IdUsuario = IdUsuario;
        this.Grado = Grado;
        this.FechaNacimiento = FechaNacimiento;
        this.Direccion = Direccion;
    }

    public Integer getIdEstudiante() {
        return IdEstudiante;
    }

    public void setIdEstudiante(Integer IdEstudiante) {
        this.IdEstudiante = IdEstudiante;
    }

    public Integer getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(Integer IdUsuario) {
        this.IdUsuario = IdUsuario;
    }

    public Integer getGrado() {
        return Grado;
    }

    public void setGrado(Integer Grado) {
        this.Grado = Grado;
    }

    public Date getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(Date FechaNacimiento) {
        this.FechaNacimiento = FechaNacimiento;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }
}
