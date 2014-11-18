/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author bernardot
 */
public class Mazo {

    private LinkedList<Carta> cartas;

    /**
     * incialización de Mazo.
     */
    public Mazo() {
        cartas = new LinkedList();
        for (int x = 0; x < 4; x++) {
            for (int y = 1; y < 14; y++) {
                Carta aux = new Carta(y, x);
                cartas.add(aux);
            }
        }
    }

    /**
     * Regresa una carta de la lista.
     * @return nCarta (Carta)
     */
    public Carta darCarta() {
        Carta nCarta = cartas.get(1);
        cartas.remove(nCarta);
        return nCarta;
    }

    /**
     * Revuelve aleatoriamente la lista de cartas
     */
    public void revolver() {
        long seed = System.nanoTime();
        Collections.shuffle(cartas, new Random(seed));
    }
}
