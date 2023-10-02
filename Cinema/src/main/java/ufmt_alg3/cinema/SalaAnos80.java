/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufmt_alg3.cinema;

import java.util.ArrayList;

public class SalaAnos80 extends Sala {
    private boolean lamparina;


    private ArrayList<String> posters = new ArrayList();

    
    
    public boolean isLamparina() {
        return lamparina;
    }
    public void setLamparina(boolean lamparina) {
        this.lamparina = lamparina;
    }

    
    public void addPosters(String poster) {
        this.posters.add(poster);
    }
        public ArrayList<String> getPosters() {  
        return posters;
    }
    
        
        
    @Override
    public double calcularPrecoDoIngresso(int numeroDeIngressos) {
        return 80.0;
    }

    @Override
    public void exibirDetalhesSala() {
        System.out.println("A sala dos anos 80 possui a premissa de trazer nostalgia, onde sempre passa filmes dos anos 80 e possui um ambiente tematico disso");
        System.out.println("No meio da sala temos o Carro do filme  De Volta para o Futuro, já que foi um grande marco dessa década ");
        }
}
