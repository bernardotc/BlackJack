/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package blackjack;

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
        Juego j = new Juego();
        j.deal();
        j.hit(j.getJugador());
    }
    
}
