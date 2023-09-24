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
    Scanner scanner = new Scanner(System.in);
    ArrayList<Sessao> lista = new ArrayList();

    public void cadastrar() throws ParseException {
        System.out.println("Cadastramento de Sessão.");
        System.out.println("Defina ID da sessão. ");
        Integer id = scanner.nextInt();
        System.out.println("Defina o tipo da sala.");
        // Sala tipoSessao = new Sala(/*Parâmetros da sala.*/);
        System.out.println("Defina o nome da sessão");
        String nomeSessao = scanner.next();
        System.out.println("Defina data e hora da sessão. Formatada como:");
        System.out.print("dd/MM/yyyy HH:mm:ss");
        String dataSessao = scanner.next();
        Sessao sessao = new Sessao(id, nomeSessao, dataSessao);
        lista.add(sessao);
    }

    public void listar() {
        System.out.println("Teste.");
    }

    public void excluir() {
        
    }
}