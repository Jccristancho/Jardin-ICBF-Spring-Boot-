package com.example.Registro_Jardines.modelo;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "Datos_Ninos")
public class registrosNinos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Registro")
    private int registro;

    @Column(name = "Nombre_n")
    private String nombre;

    @Column(name = "Fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaNacimiento;

    @Column(name = "Tipo_sangre")
    private String tipoSangre;

    @Column(name = "Ciudad_nacimiento")
    private String ciudadNacimiento;

    @Column(name = "Identificacion_acudiente")
    private int identificacionAcudiente;

    @Column(name = "Telefono")
    private String telefono;

    @Column(name = "Direccion_n")
    private String direccion;

    @Column(name = "EPS")
    private String eps;

    @ManyToOne
    @JoinColumn(name = "Identificador_Jardin", nullable = false)
    private registrosJardines jardin;



    public registrosNinos() {
    }

    public registrosNinos(int registro, String nombre, Date fechaNacimiento, String tipoSangre, String ciudadNacimiento, int identificacionAcudiente, String telefono, String direccion, String eps, registrosJardines jardin) {
        this.registro = registro;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.tipoSangre = tipoSangre;
        this.ciudadNacimiento = ciudadNacimiento;
        this.identificacionAcudiente = identificacionAcudiente;
        this.telefono = telefono;
        this.direccion = direccion;
        this.eps = eps;
        this.jardin = jardin;

    }

    public int getRegistro() {
        return registro;
    }

    public void setRegistro(int registro) {
        this.registro = registro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    public String getCiudadNacimiento() {
        return ciudadNacimiento;
    }

    public void setCiudadNacimiento(String ciudadNacimiento) {
        this.ciudadNacimiento = ciudadNacimiento;
    }

    public int getIdentificacionAcudiente() {
        return identificacionAcudiente;
    }

    public void setIdentificacionAcudiente(int identificacionAcudiente) {
        this.identificacionAcudiente = identificacionAcudiente;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEps() {
        return eps;
    }

    public void setEps(String eps) {
        this.eps = eps;
    }

    public registrosJardines getJardin() {
        return jardin;
    }

    public void setJardin(registrosJardines jardin) {
        this.jardin = jardin;
    }


}
