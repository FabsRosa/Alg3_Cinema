/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufmt_alg3.cinema;

public class SalaAnos80 extends Sala {
    private boolean lamparina;
    private String[] posters;
    private String carroDeVoltaParaOFuturo;

    public SalaAnos80(String cadeiras, String luzes, String som, boolean lamparina, String[] posters, String carroDeVoltaParaOFuturo) {
        super(cadeiras, luzes, som);
        this.lamparina = lamparina;
        this.posters = posters;
        this.carroDeVoltaParaOFuturo = carroDeVoltaParaOFuturo;
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
