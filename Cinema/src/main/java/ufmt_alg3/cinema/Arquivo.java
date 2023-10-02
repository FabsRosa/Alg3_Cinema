package ufmt_alg3.cinema;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import ufmt_alg3.autentificacao.CAutenticacao;

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
    
    public String getNomeDoArquivo() {
        return nomeDoArquivo;
    }
    
    /**
     * O método {@code salvar} é utilizado para persistir os dados de cadastro
     * de uma sessão do cinama em um arquivo.
     * 
     * @author Gabriel  
     * @param lista armazena uma lista de cadastros de sessões.
     * @param nomeArquivo é o nome do arquivo onde os dados serão guardados.
     * @throws java.io.IOException
     */

    public void salvar(ArrayList<Sessao> lista, String nomeArquivo)
            throws IOException {
        FileOutputStream fileOut = new FileOutputStream(nomeArquivo);
        ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
        objOut.writeObject(lista);
        
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
    
    public void listar(String nomeArquivo) throws FileNotFoundException,
            IOException, ClassNotFoundException, NullPointerException {
        ArrayList<Sessao> listaSessoes; 
        FileInputStream fileIn = new FileInputStream(nomeArquivo);
        ObjectInputStream objIn = new ObjectInputStream(fileIn);
        listaSessoes = (ArrayList<Sessao>) objIn.readObject();
        
        System.out.println("Lista de sessões cadastradas no arquivo: \n");
        for (Sessao sessaoAtual : listaSessoes) {
            sessaoAtual.listarSessao();
        }   
    }

    public void limpar() {
        
    }
    
    /**
     * Esse método solicita ao usuário uma senha para poder acessar as funções 
     * do arquivo, a fim de protegê-lo de potenciais ataques indesejados.
     * @return true se a senha estiver certa. False caso: o usuário 
     */
    @Override
    public boolean autenticar(){
        String senha = "123mudar";
        String verificadorSenha = "senha claramente errada";
        Integer tentativasFalhas = -1;
        while (!verificadorSenha.contains(senha)) {
            tentativasFalhas++; 
            Scanner scanner = new Scanner(System.in);
            if (tentativasFalhas == 1)
                System.out.println("Senha incorreta. Tente novamente.\n");
            
            System.out.println("INTERFACE DE ACESSO AO ARQUIVO.\n");
            System.out.print("Insira a senha para ter acesso ao arquivo:");
            verificadorSenha = scanner.nextLine();
            if (tentativasFalhas > 1) {
                System.out.println("Você errou a senha " + tentativasFalhas
                        + " vezes seguidas.");
                System.out.println("Deseja continuar? 1 Sim; 2 Não.");
                Integer sair = scanner.nextInt();
                if (sair == 1) {
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
        System.out.println("A senha está correta, saudações! :) \n");
        return true;
    }
}
