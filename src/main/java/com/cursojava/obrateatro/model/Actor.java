package com.cursojava.obrateatro.model;

import jakarta.persistence.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long actorId;

    private String nombre;
    private String papel;
    private double salario;

    private Long obra_id;

    public Actor(String nombre, String papel, double salario, Long obra_id) {
        this.nombre = nombre;
        this.papel = papel;
        this.salario = salario;
        this.obra_id = obra_id;
    }
    public Actor(){

    }

    // Constructores, getters y setters

    public Long getActorId() {
        return actorId;
    }

    public void setActorId(Long actorId) {
        this.actorId = actorId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPapel() {
        return papel;
    }

    public void setPapel(String papel) {
        this.papel = papel;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Long getObra_id() {
        return obra_id;
    }

    public void setObra_id(Long obra_id) {
        this.obra_id = obra_id;
    }
}
