package ufmt_alg3.cinema;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Virgínia Aguiar
 *         Gabriel Soares
 *         Fabrício Rosa
 */
public class Menu {
    
    public void apresentarMenu() throws ParseException, IOException,
            FileNotFoundException, ClassNotFoundException {
        
        Lista lista = new Lista();
        Arquivo arquivo = new Arquivo();
        boolean continuar = true;
        
        while (continuar) {
            Menu.skipLine();
            
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
            try {
                opt = scanner.nextInt();
            } catch (InputMismatchException nexc) {
                Menu.skipLine();
                System.out.print("Opção Inválida.");
                Menu.clearBuffer(scanner);
                continue;
            }
           
            Menu.skipLine();
            switch (opt) {
                case 1 -> {
                    if (lista.autenticar()) {
                        lista.cadastrar(arquivo.getNomeDoArquivo());
                    } else {
                        break;
                    }
                }
                case 2 -> {
                    if (lista.autenticar()){
                        lista.listar();
                    } else {
                        break;
                    }
                }
                case 3 -> {
                    if (arquivo.autenticar()){
                        arquivo.listar(arquivo.getNomeDoArquivo());
                    } else {
                        break;
                    }
                    
                }
                case 4 -> {
                    if (arquivo.autenticar()) {
                        arquivo.salvar(lista.getLista(),
                            arquivo.getNomeDoArquivo());
                    } else {
                        break;
                    }
                }
                case 5 -> {
                    if (lista.autenticar()){
                        lista.excluir();
                    } else {
                        break;
                    }
                    
                }
                case 6 -> {
                    if (arquivo.autenticar()) {
                        arquivo.limpar();
                    } else {
                        break;
                    }
                    
                }
                case 7 -> {
                    continuar = false;
                }
                default -> System.out.print("Opção Inválida.");
            }
        }
    }
    
    public static void skipLine() {

        System.out.print("\n-------------------------\n");
    }
    
    public static void clearBuffer(Scanner scanner) {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }
}