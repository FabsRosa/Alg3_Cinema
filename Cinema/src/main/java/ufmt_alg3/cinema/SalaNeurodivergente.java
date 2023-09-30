/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufmt_alg3.cinema;

/**
 *
 * @author Administrador
 */
public class SalaNeurodivergente extends Sala {
    private boolean fonesDeOuvir;
    private String iluminacaoSuave;
    private String areaDeSensoryFriendly;

    public SalaNeurodivergente(String luzes, String som, boolean fonesDeOuvir, String iluminacaoSuave, String areaDeSensoryFriendly) {
        super(luzes, som);
        this.fonesDeOuvir = fonesDeOuvir;
        this.iluminacaoSuave = iluminacaoSuave;
        this.areaDeSensoryFriendly = areaDeSensoryFriendly;
    }

    public boolean isFonesDeOuvir() {
        return fonesDeOuvir;
    }

    public void setFonesDeOuvir(boolean fonesDeOuvir) {
        this.fonesDeOuvir = fonesDeOuvir;
    }

    public String getIluminacaoSuave() {
        return iluminacaoSuave;
    }

    public void setIluminacaoSuave(String iluminacaoSuave) {
        this.iluminacaoSuave = iluminacaoSuave;
    }

    public String getAreaDeSensoryFriendly() {
        return areaDeSensoryFriendly;
    }

    public void setAreaDeSensoryFriendly(String areaDeSensoryFriendly) {
        this.areaDeSensoryFriendly = areaDeSensoryFriendly;
    }
    
   
}

