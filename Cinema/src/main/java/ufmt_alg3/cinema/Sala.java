/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufmt_alg3.cinema;

import java.io.Serializable;

/**
 *
 * @author vi
 */
public abstract class Sala implements Serializable {
    // Atributos da Sala
    String cadeiras;
    private String luzes;
    String som;
    
//metodos construtores para modelar as salas do jeito q eu quero ;)
    public Sala() {
        
    }
    
     public Sala(String luzes, String som) {
        this.luzes = luzes;
        this.som = som;
    }

    public Sala(String cadeiras, String luzes, String som) {
        this.cadeiras = cadeiras;
        this.luzes = luzes;
        this.som = som;
    }
    
    public String getCadeiras() {
        return cadeiras;
    }

    public void setCadeiras(String cadeiras) {
        this.cadeiras = cadeiras;
    }

    public String getLuzes() {
        return luzes;
    }

    public void setLuzes(String luzes) {
        this.luzes = luzes;
    }

    public String getSom() {
        return som;
    }

    public void setSom(String som) {
        this.som = som;
    }
    public abstract void exibirDetalhesSala();
    
    public abstract double calcularPrecoDoIngresso(int numeroDeIngressos);
}
