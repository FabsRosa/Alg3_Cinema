/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufmt_alg3.cinema;

import java.util.ArrayList;

public class SalaAnos80 extends Sala {
    private boolean lamparina;
    private final CarroDeVoltaParaOFuturo carro;
    private final ArrayList<String> posters = new ArrayList();
    
 public SalaAnos80(boolean lamparina, String marcaCarro, int anoCarro, String corCarro) {
        this.lamparina = lamparina;
        this.carro = new CarroDeVoltaParaOFuturo(marcaCarro, anoCarro, corCarro);
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
    public double calcularPrecoDoIngresso(int numeroDeIngressos) {
        return (numeroDeIngressos * 80.0)+ 100 ;
    }

    @Override
    public void exibirDetalhesSala() {
        System.out.println("É uma experiência que celebra a nostalgia, a diversão e a magia da década que continua a cativar os corações de pessoas de todas as idades\n" +
"\n" +
"No centro da sala, encontra-se um tesouro da cultura pop: o DeLorean DMC-12, o carro icônico do filme \"De Volta para o Futuro\"."
                + " Dizem as lendas que este carro tem o poder de realizar viagens no tempo, "
                + "um tributo perfeito à década que inspirou a imaginação de tantos. ");
        
        }
}
