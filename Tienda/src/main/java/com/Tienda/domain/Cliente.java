
package com.Tienda.domain;

import javax.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name="cliente")
public class Cliente {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY )
    private Long idCliente;
    String nombre;
    String apellidos;
    String correo;
    String telefono;
    
    @JoinColumn(name="id_credito",referencedColumnName = "id_credito")
    @ManyToOne
    private Credito credito;

    public Cliente() {
    }

    public Cliente(Long idCliente, String nombre, String apellidos, String correo, String telefono) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefono = telefono;
    }

    public Cliente(String nombre, String apellidos, String correo, String telefono, Credito credito) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefono = telefono;
        this.credito = credito;
    }
    

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }


       
}
