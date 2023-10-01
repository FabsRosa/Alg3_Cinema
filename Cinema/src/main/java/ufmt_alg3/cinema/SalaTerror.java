/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufmt_alg3.cinema;

/**
 *
 * @author vi
 */
public class SalaTerror extends Sala {
    private boolean estatuasDeDragao;
    private boolean estatuasDeFantasmas;
    private boolean lencoisManchadosDeSangue;

    public SalaTerror(String cadeiras, String luzes, String som, boolean estatuasDeDragao, boolean estatuasDeFantasmas, boolean lencoisManchadosDeSangue) {
        super(cadeiras, luzes, som);
        this.estatuasDeDragao = estatuasDeDragao;
        this.estatuasDeFantasmas = estatuasDeFantasmas;
        this.lencoisManchadosDeSangue = lencoisManchadosDeSangue;
    }

    public boolean hasEstatuasDeDragao() {
        return estatuasDeDragao;
    }

    public void setEstatuasDeDragao(boolean estatuasDeDragao) {
        this.estatuasDeDragao = estatuasDeDragao;
    }

    public boolean hasEstatuasDeFantasmas() {
        return estatuasDeFantasmas;
    }

    public void setEstatuasDeFantasmas(boolean estatuasDeFantasmas) {
        this.estatuasDeFantasmas = estatuasDeFantasmas;
    }

    public boolean hasLencoisManchadosDeSangue() {
        return lencoisManchadosDeSangue;
    }

    public void setLencoisManchadosDeSangue(boolean lencoisManchadosDeSangue) {
        this.lencoisManchadosDeSangue = lencoisManchadosDeSangue;
    }
    
    @Override
    public double calcularPrecoDoIngresso(int numeroDeIngressos){
        return 1.0;
    }
    
    @Override
    public void exibirDetalhesSala(){
        
    }
    
}

