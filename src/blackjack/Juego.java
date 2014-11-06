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
public class Juego {

    private int puntaje;
    private Mazo miMazo;
    private Mano jugador;
    private Mano dealer;
    
    public void Juego() {
        puntaje = 0;
        miMazo = new Mazo();
        jugador = new Mano(miMazo);
        dealer = new Mano(miMazo);
    }

    public void Juego(Mazo m, Mano j, Mano d) {
        puntaje = 0;
        miMazo = m;
        jugador = j;
        dealer = d;
    }

    public void Juego(int p, Mazo m, Mano j, Mano d) {
        puntaje = p;
        miMazo = m;
        jugador = j;
        dealer = d;
    }

    public void deal() {
        puntaje--;
        miMazo = new Mazo();
        jugador = new Mano(miMazo);
        dealer = new Mano(miMazo);
        miMazo.revolver();
        for (int x = 0; x < 2; x++) {
            jugador.pedirCarta();
            dealer.pedirCarta();
        }
        mostrarManos();
    }

    public boolean stand() {
        return compararManos();
    }

    public boolean hit(Mano m) {
        m.pedirCarta();
        return compararManos();
    }

    public boolean compararManos() {
        if (jugador.getSuma() > 21 || ((jugador.getSuma() < dealer.getSuma()) && dealer.getSuma() <= 21)) {
            return false;
        } else {
            return true;
        }
    }

    public void setPuntaje(int p) {
        puntaje = p;
    }

    public int getPuntaje() {
        return puntaje;
    }
    
    public void mostrarManos() {
        System.out.println("Dealer");
        dealer.mostrarCartas();
        System.out.println("Jugador");
        jugador.mostrarCartas();
    }
}
