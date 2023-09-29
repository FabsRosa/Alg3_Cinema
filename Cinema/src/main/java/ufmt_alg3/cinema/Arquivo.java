package ufmt_alg3.cinema;

import java.io.*;
import java.util.ArrayList;

/**
 * @author Virgínia Aguiar
 *         Gabriel Soares
 *         Fabrício Rosa
 */

public class Arquivo {
    
    private final String nomeDoArquivo;
    
    public Arquivo () {
        this.nomeDoArquivo = "arquivo\registrosPersistidos.ser";
    }
    
    public String getNomeDoArquivo() {
        return nomeDoArquivo;
    }
    
    public void salvar(ArrayList<Sessao> lista) throws IOException {
        File arquivo = new File(nomeDoArquivo);
        
        // Se o arquivo não existir, então ele é criado.
        if (!arquivo.exists()) {
                arquivo.createNewFile();
        }
        
        FileOutputStream fileOut = new FileOutputStream(getNomeDoArquivo());
        ObjectOutputStream out = new ObjectOutputStream(fileOut);

        // Grava o ArrayList no arquivo
        out.writeObject(lista);

        out.close();
        fileOut.close();

        System.out.println("Dados persistidos com sucesso no arquivo.");
    }

    public void listar() {
        
    }

    public void limpar() {
        
    }
}
