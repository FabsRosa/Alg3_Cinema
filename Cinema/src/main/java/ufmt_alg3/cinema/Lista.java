package ufmt_alg3.cinema;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
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
        int salaConfirmada = 0;
                
        while (opcao == 2) {
            Scanner scanner = new Scanner(System.in);
            Sessao novaSessao = new Sessao();

            System.out.println("Cadastro de Sessão.\n");
            System.out.println("ID nº " + (Sessao.getProximoId() - 1) + ".");
            
            do {
                Sala.apresentarOpcao();
                
                try {
                    escolhaSala = scanner.nextInt();
                    Menu.clearBuffer(scanner);
                } catch (InputMismatchException nexc) {
                    Menu.skipLine();
                    System.out.print("Opção Inválida.");
                    Menu.clearBuffer(scanner);
                    continue;
                }

                switch (escolhaSala) {
                    case 1 -> {
                        novaSessao.setTipoDeSessao(new SalaAnime());
                        break;
                    }
                    case 2 -> {
                        novaSessao.setTipoDeSessao(new SalaAnos80());
                        break;
                    }
                    case 3 -> {
                        novaSessao.setTipoDeSessao(new SalaMedieval());
                        break;
                    }
                    case 4 -> {
                        novaSessao.setTipoDeSessao(new SalaNeurodivergente());
                        break;
                    }
                    case 5 -> {
                        novaSessao.setTipoDeSessao(new SalaTerror());
                        break;
                    }
                    case 6 -> {
                        novaSessao.setTipoDeSessao(new SalaVip());
                        break;
                    }
                    default -> {
                        Menu.skipLine();
                        System.out.println("Opção Inválida.");
                        Menu.clearBuffer(scanner);
                        continue;
                    }
                }
                
                System.out.println("");
                novaSessao.getTipoDeSessao().exibirDetalhesSala();
                
                System.out.println("\nVocê gostaria de confirmar sua escolha?\n");
                System.out.println("1. Confirmar.");
                System.out.println("2. Voltar às opções.");
                
                try {
                    salaConfirmada = scanner.nextInt();
                    Menu.clearBuffer(scanner);
                } catch (InputMismatchException nexc) {
                    Menu.skipLine();
                    System.out.print("Opção Inválida.");
                    Menu.clearBuffer(scanner);
                    salaConfirmada = 2;
                }
            } while (salaConfirmada != 1);

            System.out.printf("\nNome da sessão: ");
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
            
            try {
                opcao = scanner.nextInt();
                Menu.clearBuffer(scanner);
            } catch (InputMismatchException nexc) {
                Menu.skipLine();
                System.out.print("Opção Inválida.");
                opcao = 1;
                Menu.clearBuffer(scanner);
            }
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
            for (int i = 0; i < 63 + sizeNomeSessao; i++) {
                System.out.printf("_");
            }
            System.out.println("");
            
            System.out.printf(" ID |  Tipo de Sala | Ingres. | %" + sizeNomeSessao + "s | Data e Hora \n", "Nome da Sessão");
            
            //Registros da tabela
            for (int i = 0; i < this.lista.size(); i++) {
                System.out.printf("%3d | ", this.lista.get( i).getId());
                System.out.printf("%13s | ", this.lista.get( i).getTipoDeSessao().retNomeSala());
                System.out.printf("%7.2f | ", this.lista.get( i).getTipoDeSessao().calcularPrecoDoIngresso());
                System.out.printf("%" + sizeNomeSessao + "s | ", this.lista.get(i).getNomeSessao());
                System.out.println(this.lista.get(i).getDataHora());
            }
        }
        
        System.out.println("");
        System.out.println("1. Retornar");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
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
            
            try {
                option = scanner.nextInt();
                Menu.clearBuffer(scanner);
            } catch (InputMismatchException nexc) {
                Menu.skipLine();
                System.out.print("Opção Inválida.");
                option = 1;
                Menu.clearBuffer(scanner);
            }
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
            String verificadorSenha = "senha claramente errada";
            Integer tentativas = 0;
            
            while (!verificadorSenha.contains(senha)) {
                tentativas++; 
                Scanner scanner = new Scanner(System.in);
                
                if (tentativas > 1)
                {
                    System.out.println("\nSenha incorreta.");
                    Menu.skipLine();
                }
                
                if (tentativas > 4) {
                    System.out.println("\nTentativas excederam o limite máximo.");
                    System.out.println("Retornando ao menu principal.");
                    return false;
                }else if (tentativas > 3) {
                    System.out.println("Você errou a senha " + (tentativas - 1) + " vezes seguidas.");
                    System.out.println("Deseja continuar?\n");
                    System.out.println("1. Sim");
                    System.out.println("2. Não");
                    Integer sair = scanner.nextInt();
                    Menu.clearBuffer(scanner);
                    Menu.skipLine();
                    
                    if (sair == 2) {
                        System.out.println("\nRetornando ao menu principal.");
                        return false;
                    }
                }

                System.out.println("Acesso aos dados de lista. \n");
                System.out.println("Auntenticação do usuário: \n");
                System.out.printf("Senha: ");
                verificadorSenha = scanner.nextLine();
            }
            System.out.printf("\nSaudações! :)");
            Menu.skipLine();
            isVerificado = true;
            return true;
        }
    }
}
