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

    /**
     * inicialización
     */
    public void Juego() {
        puntaje = 0;
        miMazo = new Mazo();
        jugador = new Mano(miMazo);
        dealer = new Mano(miMazo);
    }

    /**
     * incialización
     * @param m (Mazo)
     * @param j (Mano jugador)
     * @param d (Mano dealer)
     */
    public void Juego(Mazo m, Mano j, Mano d) {
        puntaje = 0;
        miMazo = m;
        jugador = j;
        dealer = d;
    }

    /**
     * inicialización
     * @param p (puntaje)
     * @param m (Mazo)
     * @param j (Mano jugador)
     * @param d (Mano dealer)
     */
    public void Juego(int p, Mazo m, Mano j, Mano d) {
        puntaje = p;
        miMazo = m;
        jugador = j;
        dealer = d;
    }

    /**
     * Método que reinicia el juego y entrega las cartas a las manos correspondientes.
     */
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

    /**
     * El método no hace nada con la mano del jugaor, solamente si es necesario agrega
     * cartas a la mano del dealer. Luego las compara.
     * @return true si gana el jugador, false si gana el dealer
     */
    public boolean stand() {
        mostrarManosFinal();
        while (dealer.getSuma() < 17) {
            hit(dealer);  
        }
        if (dealer.getSuma() > 21) {
            System.out.println("Dealer have busted");
            puntaje += 1;
            return true;
        } else if (compararManos()) {
            puntaje += 1;
            return true;
        } else {
            puntaje -= 1;
            return false;
        }
    }

    /**
     * Método que agrega una carta a la mano que se pase como parámetro.
     * @param m (Mano)
     * @return el valor (verdadero o falso) de comparar manos.
     */
    public boolean hit(Mano m) {
        m.pedirCarta();
         if (m.equals(dealer)){
            mostrarManosFinal();
        }
        else{
            mostrarManos();
        }
        return !compararManos();
    }

    /**
     * Método para comparar las manos del juego
     * @return true si la mano del jugador gana y false si gana la mano del dealer
     */
    public boolean compararManos() {
        if (jugador.getSuma() > 21 || ((jugador.getSuma() <= dealer.getSuma()) && dealer.getSuma() <= 21)) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * método de modificación
     * @param p
     */
    public void setPuntaje(int p) {
        puntaje = p;
    }

    /**
     * método de acceso
     * @return puntaje (puntaje total del juego)
     */
    public int getPuntaje() {
        return puntaje;
    }

    /**
     * método de modificación
     * @param m
     */
    public void setJugador(Mano m) {
        jugador = m;
    }

    /**
     * método de acceso
     * @return jugador (Mano del jugador)
     */
    public Mano getJugador() {
        return jugador;
    }

    /**
     * método de modificación
     * @param m
     */
    public void setDealer(Mano m) {
        dealer = m;
    }

    /**
     * método de acceso
     * @return dealer (Mano del dealer)
     */
    public Mano getDealer() {
        return dealer;
    }

    /**
     * método de modificación
     * @param m
     */
    public void setMiMazo(Mazo m) {
        miMazo = m;
    }

    /**
     * Método de acceso
     * @return miMazo (Mazo)
     */
    public Mazo getMiMazo() {
        return miMazo;
    }

    /**
     * Muestra todas las manos del juego con las cartas abiertas
     */
    public void mostrarManosFinal() {
        System.out.println("Dealer");
        System.out.println("Suma de cartas: " + dealer.getSuma());
        dealer.mostrarCartas();
        System.out.println("Jugador");
        System.out.println("Suma de cartas: " + jugador.getSuma());
        jugador.mostrarCartas();
    }

    /**
     * Muestra las manos del juego con la restricción de que el dealer solo muestra una.
     */
    public void mostrarManos() {
        System.out.println("Dealer");
        int val = (dealer.getCarta()).getValor();
        if (val >= 11 && val <=13){
            val = 10;
        }
        if (val == 1){
            val = 11;
        }
        System.out.println("Suma de cartas: " + val );
        dealer.mostrarCartasInicio();
        System.out.println("Jugador");
        System.out.println("Suma de cartas: " + jugador.getSuma());
        jugador.mostrarCartas();
    }
}
