/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufmt_alg3.cinema.sala;

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
        System.out.println("""
                           Essa sala possui a premissa  de  ser  tem\u00e1tica ao universo de Animes e Mang\u00e1s. 
                           decora\u00e7\u00e3o  meticulosamente  escolhida   incorpora  elementos  distintivos  das 
                           mencionadas s\u00e9ries, transportando os espectadores para os mundos dessas obras. 
                           Cada  detalhe  da  decora\u00e7\u00e3o  foi selecionado com o  prop\u00f3sito  de  criar  uma 
                           atmosfera  que  ressoa  com a ess\u00eancia do  anime  'Neon Genesis Evangelion'  e 
                           'Tokyo Ghoul'.""");
        apresentarValorIngresso();
    }
    
    @Override        
    public double calcularPrecoDoIngresso() {
        return (85.90);
    }
    
    @Override
    public String retNomeSala() {
        return "Sala Anime";
    }
}