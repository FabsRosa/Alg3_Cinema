/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufmt_alg3.cinema;

import java.util.ArrayList;

public class SalaAnos80 extends Sala {
    private boolean lamparina;
    private CarroDeVoltaParaOFuturo carro;
    private ArrayList<String> posters = new ArrayList();
    
 public SalaAnos80(boolean lamparina, String marcaCarro, int anoCarro, String corCarro) {
        this.lamparina = lamparina;
        this.carro = new CarroDeVoltaParaOFuturo(marcaCarro, anoCarro, corCarro);
    }
    public SalaAnos80() {
    }

    public void setCarro(CarroDeVoltaParaOFuturo carro) {
        this.carro = carro;
    }

    public void setPosters(ArrayList<String> posters) {
        this.posters = posters;
    }

    public CarroDeVoltaParaOFuturo getCarro() {
        return carro;
    }
    
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
    public double calcularPrecoDoIngresso() {
        return 80 ;
    }

    @Override
    public void exibirDetalhesSala() {
        System.out.println("""
                           \u00c9 uma experi\u00eancia que celebra a nostalgia, a divers\u00e3o e a magia da d\u00e9cada  que 
                           continua a cativar os cora\u00e7\u00f5es de pessoas de todas as idadesNo centro da sala, 
                           encontra-se  um tesouro da cultura pop: o DeLorean DMC-12, o carro ic\u00f4nico  do 
                           filme  'De Volta para o Futuro'. Dizem as lendas que este carro tem o poder de 
                           realizar  viagens  no  tempo,  um tributo perfeito \u00e0  d\u00e9cada  que  inspirou  a 
                           imagina\u00e7\u00e3o de tantos. 
                           """);
        apresentarValorIngresso();
    }
    
    @Override
    public String retNomeSala() {
        return "Sala Anos 80";
    } 
}
