package ufmt_alg3.cinema;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
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
        ArrayList<Sessao> dadosAtuaisArquivo = new ArrayList<>();
        
        // Verificando se o arquivo já existe no diretório padrão.
        File arquivo = new File(nomeArquivo);
        if (arquivo.exists()) {
            // Caso exista, os dados atuais do arquivo serão guardados.
            FileInputStream fileIn = new FileInputStream(nomeArquivo);
            try (ObjectInputStream objIn = new ObjectInputStream(fileIn)) {
                dadosAtuaisArquivo = (ArrayList<Sessao>) objIn.readObject();
            }
        }
        
        // Unindo as duas listas
        dadosAtuaisArquivo.addAll(lista);
        
        FileOutputStream fileOut = new FileOutputStream(nomeArquivo);
        ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
        objOut.writeObject(dadosAtuaisArquivo);
        System.out.println("Salvar dados\n");
        
        System.out.println("Lista de objetos foi salva no arquivo chamado \""
                + nomeArquivo + "\" com sucesso!\n");
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
            System.out.println("Conteúdo do arquivo: ");
            System.out.println("");
            
            for (int i = 0; i < 32 + sizeNomeSessao; i++) {
                System.out.printf("_");
            }
            System.out.println("");
            
            System.out.printf("%"+ sizeNomeSessao +"s |", "Nome da Sessão");
            System.out.println(" Data e Hora");
            
            //Registros da tabela
            for (int i = 0; i < listaSessoes.size(); i++) {
                System.out.printf("%" + sizeNomeSessao + "s", listaSessoes.get(i).getNomeSessao());
                System.out.println(" | " + listaSessoes.get(i).getDataHora());
            }
        }
        
        System.out.println("");
        System.out.println("1. Retornar");
        Scanner scanner = new Scanner(System.in);
        scanner.nextInt();
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
            Integer tentativasFalhas = -1;
            while (!verificadorSenha.contains(senha)) {
                tentativasFalhas++; 
                Scanner scanner = new Scanner(System.in);
                if (tentativasFalhas == 1)
                    System.out.println("\nSenha incorreta. Tente novamente.\n");

                System.out.println("INTERFACE DE ACESSO AO ARQUIVO.\n");
                System.out.println("Insira a senha para ter acesso ao arquivo:");
                verificadorSenha = scanner.nextLine();
                if (tentativasFalhas > 1) {
                    System.out.println("Você errou a senha " + tentativasFalhas
                            + " vezes seguidas.");
                    System.out.println("Deseja continuar? 1 Sim; 2 Não.");
                    Integer sair = scanner.nextInt();
                    if (sair == 2) {
                        System.out.println("""

                                            Você não tem acesso ao arquivo :-/ 
                                            Retornando ao menu principal.""");
                        return false;
                    }
                    /* Essa leitura de scanner abaixo serve para consumir a quebra
                     * de linha restante que o scanner.nextInt() deixa para trás;
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
