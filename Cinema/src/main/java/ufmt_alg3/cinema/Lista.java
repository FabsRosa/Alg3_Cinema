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
    public void cadastrar(String nomeArquivo) throws ParseException, 
            IOException, ClassNotFoundException {
        Integer opcao = 2;
        Integer idAtual;
        
        idAtual = Arquivo.buscarUltimoId(nomeArquivo);
        Sessao.setProximoId(idAtual);
                
            while (opcao == 2) {
                Scanner scanner = new Scanner(System.in);
                Sessao novaSessao;
                System.out.println("Cadastramento de Sessão.\n");
                System.out.println("Sessão " + Sessao.getProximoId() + "° sendo"
                + " cadastrada.");
                /*
                A implementação a seguir se refere ao cadastro da sala que ainda
                está sendo feita.

                System.out.println("Sala para a sessão: ");
                String tipoSala = scanner.nextLine();
                Sala sala = new Sala(parametros);
                */
                
                System.out.println("Nome da sessão: ");
                String nome = scanner.nextLine();
                System.out.println("Data da sessão "
                        + "(formato 'dd/MM/yyyy HH:mm:ss'): ");
                String dataHora = scanner.nextLine();
                novaSessao = new Sessao(nome, dataHora);
                lista.add(novaSessao);
                setLista(lista);
                System.out.println("Quer parar o cadastro? Sim = 1, não = 2");
                opcao = scanner.nextInt();
            }
    }

    public void listar() {
        System.out.println("Conteúdo do array: ");
        System.out.println("");
        
        for (int i = 0; i < this.lista.size(); i++) {
            System.out.println(this.lista.get( i).getId());
            System.out.println(this.lista.get(i).getNomeSessao());
            System.out.println(this.lista.get(i).getDataHora());
        }
    }

    public void excluir() {
        
    }
}