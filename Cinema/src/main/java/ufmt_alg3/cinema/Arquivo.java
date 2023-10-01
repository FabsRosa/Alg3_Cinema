package ufmt_alg3.cinema;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;

/*
 * @author Virgínia Aguiar
 * @author Gabriel Soares
 * @author Fabrício Rosa
 */

public class Arquivo {
    
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
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ClassNotFoundException
    */
    
    public void listar(String nomeArquivo) throws FileNotFoundException,
            IOException, ClassNotFoundException {
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
     * O método {@code buscarUltimoId} que abre um arquivo e checa se ele 
     * existe. Caso exista, ele desserializa os dados dele, guarda-os em uma 
     * lista e busca pelo último elemento dela. Se não existir, então retorna
     * 1
     * 
     * @param nomeArquivo representa o nome do arquivo a ser buscado o id.
     * @throws java.io.IOException
     * @throws java.lang.ClassNotFoundException
     * @return Caso o arquivo exista, ele retorna um valor Integer que 
     * representa o último valor cadastrado na lista. Se não existir, então 
     * retorna 1.
     */
    
    public static Integer buscarUltimoId(String nomeArquivo) throws IOException,
            ClassNotFoundException {
        Path caminhoArquivo = Paths.get(nomeArquivo);
        
        if (Files.exists(caminhoArquivo)) {
            ArrayList<Sessao> listaSessoes; 
            FileInputStream fileIn = new FileInputStream(nomeArquivo);
            ObjectInputStream objIn = new ObjectInputStream(fileIn);
            listaSessoes = (ArrayList<Sessao>) objIn.readObject();
        
            return (listaSessoes.get(listaSessoes.size()).getId());
        } else {
            System.out.println("O arquivo não existe. Retornando 1.");
            return 1;
        }
    }
}
