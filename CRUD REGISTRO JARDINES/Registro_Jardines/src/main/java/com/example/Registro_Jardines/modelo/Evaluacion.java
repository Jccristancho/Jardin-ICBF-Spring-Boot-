package com.example.Registro_Jardines.modelo;

import java.util.Date;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Registro_Academico")
public class Evaluacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "registroID", nullable = false)
    private registrosNinos datosNinos;



    private String nivel;
    private int notas;
    private String descripcion;
    private String asistencia;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha;


    // Constructor, getters y setters

    public Evaluacion() {
    }

    public Evaluacion(registrosNinos datosNinos, String nivel, int notas, String descripcion,
                      String asistencia, Date fecha) {
        this.datosNinos = datosNinos;
        this.nivel = nivel;
        this.notas = notas;
        this.descripcion = descripcion;
        this.asistencia = asistencia;
        this.fecha = fecha;
    }

    // Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public registrosNinos getDatosNinos() {
        return datosNinos;
    }

    public void setDatosNinos(registrosNinos datosNinos) {
        this.datosNinos = datosNinos;
    }



    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public int getNotas() {
        return notas;
    }

    public void setNotas(int notas) {
        this.notas = notas;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(String asistencia) {
        this.asistencia = asistencia;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }


}
