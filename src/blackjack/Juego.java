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
        while (dealer.getSuma() < 17) {
            hit(dealer);
        }
        if (dealer.getSuma() > 21) {
            System.out.println("Dealer have busted");
            puntaje += 1;
        } else if (compararManos()) {
            puntaje += 1;
            return true;
        } else {
            puntaje -= 1;
            return false;
        }
        return false;
    }

    public boolean hit(Mano m) {
        m.pedirCarta();
        mostrarManos();
        return !compararManos();
    }

    public boolean compararManos() {
        if (jugador.getSuma() > 21 || ((jugador.getSuma() <= dealer.getSuma()) && dealer.getSuma() <= 21)) {
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

    public void setJugador(Mano m) {
        jugador = m;
    }

    public Mano getJugador() {
        return jugador;
    }

    public void setDealer(Mano m) {
        dealer = m;
    }

    public Mano getDealer() {
        return dealer;
    }

    public void setMiMazo(Mazo m) {
        miMazo = m;
    }

    public Mazo getMiMazo() {
        return miMazo;
    }

    public void mostrarManos() {
        System.out.println("Dealer");
        System.out.println("Suma de cartas: " + dealer.getSuma());
        dealer.mostrarCartas();
        System.out.println("Jugador");
        System.out.println("Suma de cartas: " + jugador.getSuma());
        jugador.mostrarCartas();
    }
}
