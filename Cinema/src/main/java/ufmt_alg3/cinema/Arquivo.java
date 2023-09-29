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
        
        
        try (FileOutputStream fileOut = new FileOutputStream(
                getNomeDoArquivo());
                ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            // Grava o ArrayList no arquivo
            out.writeObject(lista);
            
        }

        System.out.println("Dados persistidos com sucesso no arquivo.");
    }

    public void listar() {
        
    }

    public void limpar() {
        
    }
    
    public Integer buscarUltimoId() throws IOException, ClassNotFoundException {
        // Variáveis locais auxiliares.
        String nomeArquivo;
        Integer ultimoId;
        nomeArquivo = getNomeDoArquivo();
        
        /*
         * O seguinte trecho de código será utilizado para desserializar os
         * objetos guardados no arquivo, armazenando-os em uma lista.
         */
        FileInputStream arquivo = new FileInputStream(nomeArquivo);
        try (ObjectInputStream sessao = new ObjectInputStream(arquivo)) {
            ArrayList<Sessao> listaDoArq = (ArrayList<Sessao>)
                    sessao.readObject();
            
            // Verifica se o arquivo não está vazio.
            if (!listaDoArq.isEmpty()) {
                // Obtém o último objeto da lista
                Sessao ultimoObjeto = listaDoArq.get(listaDoArq.size() - 1);

                // Acessa o atributo desejado do último registro
                ultimoId = ultimoObjeto.getId();
                return ultimoId;
            } else {
                System.out.println("O arquivo está vazio.");
            }
        }
        return null;
    }
}
