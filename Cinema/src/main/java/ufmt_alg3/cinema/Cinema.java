package ufmt_alg3.cinema;

import ufmt_alg3.cinema.navegacao.Menu;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

/**
 * @author Virgínia Aguiar
 *         Gabriel Soares
 *         Fabrício Rosa
 */
public class Cinema {

    public static void main(String[] args) throws ParseException, IOException,
            FileNotFoundException, ClassNotFoundException {
        Menu menu = new Menu();
        menu.apresentarMenu();
    }
}
