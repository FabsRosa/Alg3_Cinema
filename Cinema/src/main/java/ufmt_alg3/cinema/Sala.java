package ufmt_alg3.cinema;

import java.io.Serializable;
import java.util.Scanner;


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
    
    public static void apresentarOpcao(){
        
        System.out.println("\nEscolha a sala de sua prefêrencia: \n");
        System.out.println("1. Sala com tematica de Anime");
        System.out.println("2. Sala com tematica dos Anos 80");
        System.out.println("3. Sala com tematica Medieval");
        System.out.println("4. Sala apropriada para pessoas Neurodivergentes");
        System.out.println("5. Sala com tematica de Terror");
        System.out.println("6. Sala VIP");  
    }
        
    public void apresentarValorIngresso() {
        System.out.printf("\nValor do Ingresso: R$ %6.2f", this.calcularPrecoDoIngresso());
    }
    
    public abstract String retNomeSala();
    
    public abstract void exibirDetalhesSala();
    
    public abstract double calcularPrecoDoIngresso();
}