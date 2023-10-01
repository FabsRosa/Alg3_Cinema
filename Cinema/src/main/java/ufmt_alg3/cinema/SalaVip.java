/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufmt_alg3.cinema;

/**
 *
 * @author Administrador
 */
public class SalaVip extends Sala {
    private String cadeirasConfortaveis;
    private String luzesAmarelas;
    private String tapetesVermelhos;
    
    public SalaVip(String cadeiras, String luzes, String som, String cadeirasConfortaveis, String luzesAmarelas, String tapetesVermelhos) {
        super(cadeiras, luzes, som); // Chamando o construtor da classe pai (Sala
        this.cadeirasConfortaveis = cadeirasConfortaveis;
        this.luzesAmarelas = luzesAmarelas;
        this.tapetesVermelhos = tapetesVermelhos;
    }

    /**
     *
     * @return
     */
    public String getCadeirasConfortaveis() {
        return cadeirasConfortaveis;
    }
        public void setCadeirasConfortaveis(String cadeirasConfortaveis) {
        this.cadeirasConfortaveis = cadeirasConfortaveis;
    }
   public String getLuzesAmarelas() {
        return luzesAmarelas;
    }
       public void setLuzesAmarelas(String luzesAmarelas) {
        this.luzesAmarelas = luzesAmarelas;
    }
    public String getTapetesVermelhos() {
        return tapetesVermelhos;
    }
    public void setTapetesVermelhos(String tapetesVermelhos) {
        this.tapetesVermelhos = tapetesVermelhos;
    }
    
    @Override
    public double calcularPrecoDoIngresso(int numeroDeIngressos){
        return 1.0;
    }
    
    @Override
    public void exibirDetalhesSala(){
        
    }
       
}
