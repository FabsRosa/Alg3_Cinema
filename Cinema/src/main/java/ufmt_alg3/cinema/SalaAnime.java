/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufmt_alg3.cinema;

public class SalaAnime extends Sala {
    private boolean decoracaoTokyoGhoul;
    private boolean decoracaoEvangelion;

    
    public SalaAnime(String cadeiras, String luzes, String som) {
        
        super(cadeiras, luzes, som);
        
    }

    public void setDecoracaoTokyoGhoul(boolean decoracaoTokyoGhoul) {
        this.decoracaoTokyoGhoul = decoracaoTokyoGhoul;
    }

    public boolean isDecoracaoTokyoGhoul() {
        return decoracaoTokyoGhoul;
    }

    public void setDecoracaoEvangelion(boolean decoracaoEvangelion) {
        this.decoracaoEvangelion = decoracaoEvangelion;
    }

    public boolean isDecoracaoEvangelion() {
        return decoracaoEvangelion;
    }
}
