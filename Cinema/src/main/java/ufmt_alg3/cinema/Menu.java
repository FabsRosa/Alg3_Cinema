package ufmt_alg3.cinema;
import java.text.ParseException;
import java.util.Scanner;

/**
 * @author Virgínia Aguiar
 *         Gabriel Soares
 *         Fabrício Rosa
 */
public class Menu {
    
    public void apresentarMenu() throws ParseException {
        Scanner scanner = new Scanner(System.in);
        Lista lista = new Lista();
        Arquivo arquivo = new Arquivo();
        
        while (true) {
            int opt;
        
            System.out.println("Menu");
            System.out.println("");
            System.out.println("1. Cadastrar.");
            System.out.println("2. Listar array.");
            System.out.println("3. Listar arquivo físico.");
            System.out.println("4. Salvar dados.");
            System.out.println("5. Excluir item do array.");
            System.out.println("6. Limpar arquivo físico.");
            System.out.println("7. Sair.");
        
            opt = scanner.nextInt();
            this.limparConsole();
            switch (opt) {
                case 1 -> {
                    lista.cadastrar();
                }
                case 2 -> {
                    lista.listar();
                }
                case 3 -> {
                    arquivo.listar();
                }
                case 4 -> {
                    arquivo.salvar();
                }
                case 5 -> {
                    lista.excluir();
                }
                case 6 -> {
                    arquivo.limpar();
                }
                case 7 -> {
                    return;
                }
            }
        }
    }
    
    public void limparConsole() {
        System.out.print("\n\n\n\n\n\n\n\n\n");
    }
}
