package ufmt_alg3.cinema;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Virgínia Aguiar
 *         Gabriel Soares
 *         Fabrício Rosa
 */

public class Lista {
    
    private ArrayList<Sessao> lista = new ArrayList();

    public ArrayList<Sessao> getLista() {
        return this.lista;
    }
    
    public void setLista(ArrayList<Sessao> lista) {
        this.lista = lista;
    }
    
    /**
     * Esse método mostra no console uma interface de texto para o cadastramen-
     * to de uma sessão na em uma sala do cinema. Ele armazena os registros
     * em um {@code ArrayList}.
     * 
     * @param nomeArquivo
     * @throws java.text.ParseException
     * @throws java.io.IOException
     * @throws java.lang.ClassNotFoundException
     */
    public void cadastrar(String nomeArquivo) throws ParseException, IOException, ClassNotFoundException {
        Integer opcao = 2;
                
            while (opcao == 2) {
                Scanner scanner = new Scanner(System.in);
                Sessao novaSessao;
                
                System.out.println("Cadastro de Sessão.\n");
                System.out.println("ID nº " + Sessao.getProximoId() + ".");
                
                System.out.printf("Nome da sessão: ");
                String nome = scanner.nextLine();
                System.out.printf("Data da sessão " + "(formato 'dd/MM/yyyy HH:mm:ss'): ");
                String dataHora = scanner.nextLine();

                novaSessao = new Sessao(nome, dataHora);
                lista.add(novaSessao);
                setLista(lista);
                
                System.out.println("");
                System.out.println("Sessão cadastrada com sucesso.");
                System.out.println("");
                System.out.println("1. Retornar.");
                System.out.println("2. Cadastrar outra Sessão.");
                opcao = scanner.nextInt();
            }
    }

    public void listar() {
        int sizeNomeSessao = 14; // Determina o tamanho da coluna "Nome da Sessão"
        
        if (this.lista.isEmpty()) {
            System.out.println("Array vazio.");
        } else {
            // Definindo tamanho da coluna "Nome da Sessão"
            for (int i = 0; i < this.lista.size(); i++) {
                if (sizeNomeSessao < this.lista.get(i).getNomeSessao().length())
                sizeNomeSessao = this.lista.get(i).getNomeSessao().length();
            }

            // Tabela apresentando os dados do array
            System.out.println("Conteúdo do array: ");
            System.out.println("");
            
            for (int i = 0; i < 37 + sizeNomeSessao; i++) {
                System.out.printf("_");
            }
            System.out.println("");
            
            System.out.printf(" ID |");
            System.out.printf(" %"+ sizeNomeSessao +"s |", "Nome da Sessão");
            System.out.println(" Data e Hora");
            
            //Registros da tabela
            for (int i = 0; i < this.lista.size(); i++) {
                System.out.printf("%3d | ", this.lista.get( i).getId());
                System.out.printf("%" + sizeNomeSessao + "s", this.lista.get(i).getNomeSessao());
                System.out.println(" | " + this.lista.get(i).getDataHora());
            }
        }
        
        System.out.println("");
        System.out.println("1. Retornar");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    public void excluir() {
        
    }
}