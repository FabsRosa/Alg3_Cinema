/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufmt_alg3.cinema;

/**
 *
 * @author Administrador
 */
public class SalaMedieval extends Sala{
    private boolean luzDeTochas;
    private boolean chaoDeMadeira;
    
    public SalaMedieval(String cadeiras, String luzes, String som) {
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
    
}
