package ufmt_alg3.cinema;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * @author Virgínia Aguiar
 * @author Gabriel Soares
 * @author Fabrício Rosa
 */

/**
 * Essa classe é responsável por todas as manipulações feitas no arquivo. São 
 * elas: salvar registros de sessões serializados em um arquivo .dat; buscar um
 * arquivo, desserializá-lo e listar os elementos de dentro dele; buscar o 
 * arquivo com os salvamentos e limpá-lo.
 */

public class Arquivo implements CAutenticacao {
    
    private final String nomeDoArquivo = "arquivo_registros.dat";
    private static boolean isVerificado = false;
    
    public String getNomeDoArquivo() {
        return nomeDoArquivo;
    }
    
    /**
     * O método {@code salvar} é utilizado para persistir os dados de cadastro
     * de uma sessão do cinema em um arquivo. Se o arquivo já existe, então ele
     * acrescenta as novas sessões no final do arquivo. Senão, ele cria um novo
     * arquivo e faz os registros nele.
     * 
     * @author Gabriel  
     * @param lista armazena uma lista de cadastros de sessões.
     * @param nomeArquivo é o nome do arquivo onde os dados serão guardados.
     * @throws java.io.IOException
     * @throws java.lang.ClassNotFoundException
     */

    public void salvar(ArrayList<Sessao> lista, String nomeArquivo)
            throws IOException, ClassNotFoundException {
        // Coleção para armazenar os dados do arquivo.
        ArrayList<Sessao> dadosAtuais = new ArrayList<>();
        
        // Verificando se o arquivo já existe no diretório padrão.
        File arquivo = new File(nomeArquivo);
        if (arquivo.exists()) {
            FileInputStream fileIn = new FileInputStream(nomeArquivo);
            try (ObjectInputStream objIn = new ObjectInputStream(fileIn)){
                dadosAtuais = (ArrayList<Sessao>) objIn.readObject();
            }
            fileIn.close();
        }
        
        // Unindo os dados do arquivo e os novos.
        dadosAtuais.addAll(lista);
        
        FileOutputStream fileOut = new FileOutputStream(nomeArquivo);
        try (ObjectOutputStream objOut = new ObjectOutputStream(fileOut)) {
            objOut.writeObject(dadosAtuais);
            fileOut.close();
            objOut.close();
        }
        System.out.println("Salvar dados\n");
            
        System.out.println("Dados salvos com sucesso!");
        System.out.println("Arquivo: '" + nomeArquivo + "'");
        
        lista.clear();
        Sessao.setProximoId(1);
    }    

    /**
     * O método {@code listar} abre um arquivo serializado (.dat), extrai os 
     * objetos nele armazenados em uma coleção ArrayList. Após extrair tudo de 
     * dentro dos arquivos, o método usa a lista de cópia para ler os dados e
     * imprimí-los no console.
     * 
     * @param nomeArquivo
     * @throws java.io.FileNotFoundException
     * @throws java.lang.ClassNotFoundException
     * @throws java.io.IOException
     * @throws java.lang.NullPointerException
    */
    
    public void listar(String nomeArquivo) throws FileNotFoundException, IOException, ClassNotFoundException, NullPointerException {
        ArrayList<Sessao> listaSessoes;
        FileInputStream fileIn;
        int sizeNomeSessao = 14; // Determina o tamanho da coluna "Nome da Sessão"

        System.out.println("Listar arquivo físico\n");
        try {
            fileIn = new FileInputStream(nomeArquivo);
        } catch (FileNotFoundException nexc) {
            System.out.println("Arquivo não encontrado!");
            return;
        }
        
        ObjectInputStream objIn = new ObjectInputStream(fileIn);
        listaSessoes = (ArrayList<Sessao>) objIn.readObject();
        
        if (listaSessoes.isEmpty()) {
            System.out.println("Arquivo vazio.");
        } else {
            // Definindo tamanho da coluna "Nome da Sessão"
            for (int i = 0; i < listaSessoes.size(); i++) {
                if (sizeNomeSessao < listaSessoes.get(i).getNomeSessao().length())
                sizeNomeSessao = listaSessoes.get(i).getNomeSessao().length();
            }

            // Tabela apresentando os dados do arquivo
            for (int i = 0; i < 58 + sizeNomeSessao; i++) {
                System.out.printf("_");
            }
            System.out.println("");
            
            System.out.printf("  Tipo de Sala | Ingres. | %" + sizeNomeSessao + "s | Data e Hora \n", "Nome da Sessão");
            
            try {
                // Registros da tabela
                for (int i = 0; i < listaSessoes.size(); i++) {
                    System.out.printf(" %13s | ", listaSessoes.get( i).getTipoDeSessao().retNomeSala());
                    System.out.printf("%7.2f | ", listaSessoes.get( i).getTipoDeSessao().calcularPrecoDoIngresso());
                    System.out.printf("%" + sizeNomeSessao + "s", listaSessoes.get(i).getNomeSessao());
                    System.out.println(" | " + listaSessoes.get(i).getDataHora());
                }
            } catch(NullPointerException nexc) {
                System.out.println("\nArquivo não encontrado.");
                return;
            }
        }
        
        System.out.println("");
        System.out.println("1. Retornar");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    public void limpar() {
        System.out.println("Limpar arquivo físico\n");
    }
    
    /**
     * Esse método solicita ao usuário uma senha para poder acessar as funções 
     * do arquivo, a fim de protegê-lo de potenciais ataques indesejados.
     * @return true se a senha estiver certa. False caso: o usuário 
     */
    @Override
    public boolean autenticar(){
        if (isVerificado) {
            return true;
        } else {
            String senha = "123mudar";
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

                System.out.println("Acesso aos dados de arquivo. \n");
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
