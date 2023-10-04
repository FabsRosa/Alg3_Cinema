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

public class Lista implements CAutenticacao{
    
    private ArrayList<Sessao> lista = new ArrayList();
    private static boolean isVerificado = false;

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
        int opcao = 2;
        int escolhaSala;
        int salaConfirmada;
              
                
        while (opcao == 2) {
            Scanner scanner = new Scanner(System.in);
            Sessao novaSessao = new Sessao();

            System.out.println("Cadastro de Sessão.\n");
            System.out.println("ID nº " + (Sessao.getProximoId() - 1) + ".");
            
            do {
                System.out.println("Escolha a sala de sua prefêrencia:) ");
                System.out.println("Digite 1 para a Sala com tematica de Anime");
                System.out.println("Digite 2 para a Sala com tematica dos Anos 80");
                System.out.println("Digite 3 para a Sala com tematica Medieval");
                System.out.println("Digite 4 para a Sala apropriada para pessoas Neurodivergentes");
                System.out.println("Digite 5 para a Sala com tematica de Terror");
                System.out.println("Digite 6 para a Sala VIP");    

                escolhaSala = scanner.nextInt();

                switch (escolhaSala) {
                    case 1 -> {
                        novaSessao.tipoDeSessao = new SalaAnime();
                        break;
                    }
                    case 2 -> {
                        novaSessao.tipoDeSessao = new SalaAnos80();
                        break;
                    }
                    case 3 -> {
                        novaSessao.tipoDeSessao = new SalaMedieval();
                        break;
                    }
                    case 4 -> {
                        novaSessao.tipoDeSessao = new SalaNeurodivergente();
                        break;
                    }
                    case 5 -> {
                        novaSessao.tipoDeSessao = new SalaTerror();
                        break;
                    }
                    case 6 -> {
                        novaSessao.tipoDeSessao = new SalaVip();
                        break;
                    }
                    default -> {
                        System.out.println("Opção Inválida.");
                    }
                }
                
                novaSessao.tipoDeSessao.exibirDetalhesSala();
                novaSessao.tipoDeSessao.calcularPrecoDoIngresso();
                
                System.out.println("Você gostaria de confirmar sua escolha?");
                System.out.println("1. Confirmar.");
                System.out.println("2.Ver novamente as opções.");
                
                salaConfirmada = scanner.nextInt();
                
            } while (salaConfirmada == 2);

            System.out.printf("Nome da sessão: ");
            novaSessao.setNomeSessao(scanner.nextLine());

            System.out.printf("Data da sessão " + "(formato 'dd/MM/yyyy HH:mm:ss'): ");
            while (!novaSessao.setDataHora(scanner.nextLine())) {
                System.out.println("A Data ou Hora não está com formatação compatível.\n");
                System.out.printf("Data da sessão " + "(formato 'dd/MM/yyyy HH:mm:ss'): ");
            }

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
        System.out.println("Listar array\n");
        
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
        scanner.nextInt();
    }

    public void excluir() {
        int input;
        int option = 2;
        boolean isDeleted;
        
        System.out.println("Excluir item do array\n");
        
        while (option == 2) {
            isDeleted = false;
            
            System.out.print("\nDigite o ID do registro que deseja excluir: ");
            Scanner scanner = new Scanner(System.in);
            input = scanner.nextInt();

            for (int i = 0; i < this.lista.size(); i++) {
                if (this.lista.get( i).getId() == input) {
                    this.lista.remove(i);
                    isDeleted = true;
                    break;
                }
            }
            
            if (isDeleted) {
                System.out.println("\nRegistro excluído com sucesso.");
            } else {
                System.out.println("\nID não encontrado.");
            }
            
            System.out.println("");
            System.out.println("1. Retornar.");
            System.out.println("2. Excluir outro registro.");
            option = scanner.nextInt();
        }
    }
    
    /**
     * Esse método gerencia qual usuário pode utilizar algum método da lista.
     * 
     * @return true se a senha estiver correta, senão retorna false.
     */
    @Override
    public boolean autenticar() {
        if (isVerificado) {
            return true;
        } else {
            String senha = "lista123";
            String verificarSenha = "eu estou, claramente, errada.";
            Integer tentativasFalhas = -1;

            while (!verificarSenha.contains(senha)) {            
                tentativasFalhas++;
                Scanner scanner = new Scanner(System.in);
                if (tentativasFalhas == 1)
                    System.out.println("\nSenha incorreta. Tente novamente.\n");

                System.out.println("INTERFACE DE ACESSO A LISTA.\n");
                System.out.println("Insira a senha da lista:");
                verificarSenha = scanner.nextLine();
                if (tentativasFalhas > 1) {
                    System.out.println("Você errou a senha " + tentativasFalhas
                            + " vezes seguidas.");
                    System.out.println("Deseja continuar? 1 Sim; 2 Não.");
                    Integer sair = scanner.nextInt();
                    if (sair == 2) {
                        System.out.println("""
                                           Você não tem acesso a lista :-/ 
                                           Retornando ao menu principal! \n
                                           """);
                        return false;
                    }
                    /* Essa leitura de scanner abaixo serve para consumir a quebra
                     * de linha restante ao usar o scanner.nextInt();
                    */
                    scanner.nextLine();
                }
            }
            System.out.println("A senha está correta, saudações! :)");
            System.out.print("\n-------------------------\n");
            isVerificado = true;
            return true;
        }
    }
}