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

        // Prepara el input para que el jugador pueda teclear sus opciones
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(inputStreamReader);

        // Variables que van a ser usadas para saber el estado del juego
        char x = 'e';
        boolean play = true;

        // Inicia el juego
        Juego j = new Juego();

        System.out.println("Score: " + j.getPuntaje());
        j.deal();

        // Ciclo mientras el jugador quiera estar jugando.
        do {
            // Da la oportunidad de que el usuario escoja en base a su carta
            System.out.println("¿Que quieres hacer? ('d' para deal, 'h' para hit, 's' para stand y 'e' para terminar)");
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

            // Checa la opción que el usuario escogió
            // (Deal)
            if (x == 'd') {
                if (play) {
                    j.setPuntaje(j.getPuntaje() - 1);
                }
                System.out.println("Score: " + j.getPuntaje());
                j.deal();
                play = true;
                // (Hit)
            } else if (x == 'h' && play) {
                if (j.getJugador().getSuma() <= 21) {
                    j.hit(j.getJugador());
                    if (j.getJugador().getSuma() > 21) {
                        System.out.println("You have busted");
                        j.setPuntaje(j.getPuntaje() - 1);
                        play = false;
                    }
                } else {
                    System.out.println("Dealer won");
                }
                // (Stand)
            } else if (x == 's' && play) {
                play = false;
                if (j.stand()) {
                    System.out.println("You won");
                } else {
                    System.out.println("Dealer won");
                }
            }
        } while (x != 'e');
    }

}
