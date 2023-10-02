/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufmt_alg3.cinema;

import java.util.Scanner;

/**
 *
 * @author vi
 */
public abstract class Sala {
    // Atributos da Sala
    String cadeiras;
    private String luzes;
    String som;
    
//metodos construtores para modelar as salas do jeito q eu quero ;)
   
    public Sala() {
    
    }

    /**
     *
     * @param scanner
     * @return
     */
    public int apresentarOpcao(Scanner scanner){
        
        System.out.println("Garantimos uma esperiencia imersiva e personalizada para você."
                          + "Escolha a sala de sua prefêrencia :) ");
        System.out.println("Digite 3 para a Sala com tematica de Anime");
        System.out.println("Digite 4 para a Sala com tematica de Anos 80");
        System.out.println("Digite 5 para a Sala com tematica de Era Medieval");
        System.out.println("Digite 6 para a Sala apropriada para pessoas Neurodivergentes");
        System.out.println("Digite 7 para a Sala com tematica de Terror");
        System.out.println("Digite 8 para a Sala VIP");     
         // Lê a escolha do usuário
        return scanner.nextInt();
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
