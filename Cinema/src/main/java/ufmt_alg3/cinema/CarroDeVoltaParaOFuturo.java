package ufmt_alg3.cinema;

/**
 *
 * @author Administrador
 */
public class CarroDeVoltaParaOFuturo {
    private final String marca;
    private int ano;
    private final String cor;

    public CarroDeVoltaParaOFuturo(String marca, int ano, String cor) {
        this.marca = marca;
        this.ano = ano;
        this.cor = cor;
    }

    public void viajarNoTempo(int anos) {
        if (anos > 0) {
            ano -= anos; // voltar 
            System.out.println("O carro voltou " + anos + " anos no tempo e agora é do ano " + ano);
        } else if (anos < 0) {
            ano -= anos; // Ir para o futuro (anos negativos)
            System.out.println("O carro foi para o futuro " + (-anos) + " anos e agora é do ano " + ano);
        } else {
            System.out.println("O carro permanece no mesmo ano.");
        }
    }

    public String getMarca() {
        return marca;
    }

    public int getAno() {
        return ano;
    }

    public String getCor() {
        return cor;
    }
}