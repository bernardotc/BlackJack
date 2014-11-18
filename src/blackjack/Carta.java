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

    /**
     * incialización
     */
    public Carta() {
        valor = palo = 0;
    }

    /**
     * inicialización
     * @param v (calor de la carta)
     * @param p (palo de la carta)
     */
    public Carta(int v, int p) {
        valor = v;
        palo = p;
    }

    /**
     * método de acceso
     * @return valor (el valor de la carta)
     */
    public int getValor() {
        return valor;
    }

    /**
     * método de acceso
     * @return palo (el palo de la carta)
     */
    public int getPalo() {
        return palo;
    }

    /**
     * método de modificación
     * @param v (el valor de la carta)
     */
    public void setValor(int v) {
        valor = v;
    }

    /**
     * método de modificación
     * @param p (el palo de la carta)
     */
    public void setPalo(int p) {
        palo = p;
    }
}
