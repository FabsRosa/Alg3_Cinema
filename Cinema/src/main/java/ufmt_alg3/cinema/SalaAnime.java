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
    public SalaAnime() {
        
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
        @Override
    public void exibirDetalhesSala() {
        System.out.println("Essa sala possui a premissa de ser temática ao universo de Animes e Mangás. "
                + ""
                + "decoração meticulosamente escolhida incorpora elementos distintivos das mencionadas séries,"
                + ""
                + " transportando os espectadores para os mundos dessas obras. Cada detalhe da decoração "
                + ""
                + "foi selecionado com o propósito de criar uma atmosfera que ressoa com a essência do anime "
                + ""
                + "'Neon Genesis Evangelion' e 'Tokyo Ghoul'.");
    }
    
    @Override        
    public double calcularPrecoDoIngresso() {
        return (85.90);
    }
}