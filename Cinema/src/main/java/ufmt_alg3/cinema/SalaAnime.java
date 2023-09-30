/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufmt_alg3.cinema;

/**
 *
 * @author Administrador
 */
public class SalaAnime extends Sala{
    private final String decoracaoTokyoGhoul;
    private final String decoracaoNaruto;
    private final String decoracaoKimiNoNaWa;
    
    
    public SalaAnime(String cadeiras, String luzes, String som) {
        //herdado da sala 
        super(cadeiras, luzes, som);
        //objetos da sala
        this.decoracaoTokyoGhoul = "Tokyo Ghoul";
        this.decoracaoNaruto = "Naruto";
        this.decoracaoKimiNoNaWa = "Kimi no Na wa";
    }
    public String getDecoracaoTokyoGhoul() {
        return decoracaoTokyoGhoul;
    }

    public String getDecoracaoNaruto() {
        return decoracaoNaruto;
    }

    public String getDecoracaoKimiNoNaWa() {
        return decoracaoKimiNoNaWa;
    }
}
