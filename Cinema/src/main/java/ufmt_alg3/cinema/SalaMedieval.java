/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufmt_alg3.cinema;

public class SalaMedieval extends Sala{
    private boolean luzDeTochas;
    private boolean chaoDeMadeira;
    
    public SalaMedieval(String cadeiras, String luzes, String som, boolean luzDeTochas, boolean chaoDeMadeira) {
        super(cadeiras, luzes, som);
        this.luzDeTochas = luzDeTochas;
        this.chaoDeMadeira = chaoDeMadeira;
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
        return 1.0;
    }
    
    @Override
    public void exibirDetalhesSala(){
        
    }
    
}
