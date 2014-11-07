/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bernardot
 */
public class BlackJack {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(inputStreamReader);

        char x = 'e';

        Juego j = new Juego();

        j.deal();

        do {
            if (x != 's' || x != 'd' || x != 'h' || x != 'e') {
                System.out.println("¿Que quieres hacer? ('d' para deal, 'h' para hit, 's' para stand y 'e' para terminar");
                try {
                    x = (char) reader.read();
                } catch (IOException ex) {
                    Logger.getLogger(BlackJack.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    reader.skip(1);
                } catch (IOException ex) {
                    Logger.getLogger(BlackJack.class.getName()).log(Level.SEVERE, null, ex);
                }

                if (x == 'd') {
                    j.deal();
                } else if (x == 'h') {
                    j.hit(j.getJugador());
                } else if (x == 's') {
                    j.stand();
                }
            }
        } while (x != 'e');
    }

}
