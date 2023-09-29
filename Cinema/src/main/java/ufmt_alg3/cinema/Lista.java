package ufmt_alg3.cinema;
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
    
    public void cadastrar() throws ParseException {
        Integer opcao = 2;
        /*
        Aqui pretendo criar um método estático para buscar no arquivo o último
        id registrado para usá-lo no registro das novas sessões.
         */ // proximoId = getProximoIDArquivo();
                
            while (opcao == 2) {
                Scanner scanner = new Scanner(System.in);
                Sessao novaSessao;
                System.out.println("Cadastramento de Sessão.\n");
                /*
                A implementação a seguir se refere ao cadastro da sala que ainda
                está sendo feita.
                
                System.out.println("Sessão " + proximoId + "° sendo cadastrada.");
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
                
                /*Esse scanner abaixo serve para limpar o buffer anterior
                "nextInt()". Ele é feito pois o método anterior não consome to-
                talmente a linha após ler o número inteiro e sobra uma quebra
                de linha em "nextLine()" que lê o nome da sessão.
                */
            }
    }

    public void listar() {
        System.out.println("Teste.");
    }

    public void excluir() {
        
    }
}