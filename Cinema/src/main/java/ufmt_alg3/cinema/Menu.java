package ufmt_alg3.cinema;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

/**
 * @author Virgínia Aguiar
 *         Gabriel Soares
 *         Fabrício Rosa
 */
public class Menu {
    
    public void apresentarMenu() throws ParseException, IOException {
        
        Lista lista = new Lista();
        Arquivo arquivo = new Arquivo();
        boolean continuar = true;
        
        while (continuar) {
            Integer opt;
            Scanner scanner = new Scanner(System.in);
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
                    arquivo.salvar(lista.getLista(),
                            arquivo.getNomeDoArquivo());
                }
                case 5 -> {
                    lista.excluir();
                }
                case 6 -> {
                    arquivo.limpar();
                }
                case 7 -> {
                    continuar = false;
                }
                default -> System.out.println("Opção Inválida.");
            }
        }
    }
    
    public void limparConsole() {
        System.out.print("\n\n\n\n\n\n\n\n\n");
    }
}
