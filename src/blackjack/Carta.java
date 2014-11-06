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
public class Carta {

    private int valor;
    private int palo;

    public Carta() {
        valor = palo = 0;
    }

    public Carta(int v, int p) {
        valor = v;
        palo = p;
    }

    public int getValor() {
        return valor;
    }

    public int getPalo() {
        return palo;
    }

    public void setValor(int v) {
        valor = v;
    }

    public void setPalo(int p) {
        palo = p;
    }
}
