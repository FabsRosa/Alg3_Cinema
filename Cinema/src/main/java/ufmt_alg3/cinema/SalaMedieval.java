/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufmt_alg3.cinema;

public class SalaMedieval extends Sala{
    private boolean luzDeTochas;
    private boolean chaoDeMadeira;
    private boolean PortasDeMetalPesadas;
    
    public SalaMedieval(String cadeiras, String luzes, String som, boolean luzDeTochas, boolean chaoDeMadeira, boolean PortasDeMetalPesadas) {
        super(cadeiras, luzes, som);
        this.luzDeTochas = luzDeTochas;
        this.chaoDeMadeira = chaoDeMadeira;
        this.PortasDeMetalPesadas = PortasDeMetalPesadas;
    }
     public boolean hasLuzDeTochas() {
        return luzDeTochas;
    }

    public void setLuzDeTochas(boolean luzDeTochas) {
        this.luzDeTochas = luzDeTochas;
    }

    public boolean hasChaoDeMadeira() {
        return chaoDeMadeira;
    }

    public void setChaoDeMadeira(boolean chaoDeMadeira) {
        this.chaoDeMadeira = chaoDeMadeira;
    }
    
    @Override
    public double calcularPrecoDoIngresso(int numeroDeIngressos){
        return 178.0;
    }
    
    @Override
    public void exibirDetalhesSala(){
        System.out.println("Essa sala possui a premissa de ser um ambiente medieval, possui o chão de madeira, e tochas de fogo como luzes, afim de passar algumas sessoes que remetem a esse estilo, como senhor dos aneis");
 
    }
    
}