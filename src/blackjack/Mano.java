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
public class Mano {

    private int suma;
    private Carta[] misCartas;
    private int cantidadCartas;
    private Mazo mazo;

    /**
     * inicialización
     * @param m (Mazo)
     */
    public Mano(Mazo m) {
        mazo = m;
        suma = 0;
        misCartas = new Carta[10];
    }

    /**
     * Agrega a la lista de cartas local de mano, una carta que el mazo da.
     */
    public void pedirCarta() {
        misCartas[cantidadCartas] = mazo.darCarta();
        int aux = misCartas[cantidadCartas].getValor();
        if (aux > 10) {
            suma += 10;
        } else if (aux == 1) {
            suma += 11;
        } else {
            suma += aux;
        }
        cantidadCartas++;
    }
    
    /**
     * método de acceso
     * @return misCartas (Carta)
     */
    public Carta getCarta(){
        return misCartas[0];
    }

    /**
     * método de acceso
     * @return suma (Suma de los valores de las cartas)
     */
    public int getSuma() {
        return suma;
    }

    /**
     * método de modificación
     * @param s
     */
    public void setSuma(int s) {
        suma = s;
    }

    /**
     * método de acceso
     * @return cantidadCartas
     */
    public int getCantidadCartas() {
        return cantidadCartas;
    }

    /**
     * método de modificación
     * @param c (cantidadCartas)
     */
    public void setCantidadCartas(int c) {
        cantidadCartas = c;
    }

    /**
     * método que sirve para mostrar todas las cartas de ambas manos de una forma ordenada.
     */
    public void mostrarCartas() {
        for (int x = 0; x < cantidadCartas; x++) {
            String palo = "";
            if (misCartas[x].getPalo() == 1) {
                palo = "Corazones";
            } else if (misCartas[x].getPalo() == 2) {
                palo = "Trebol";
            } else if (misCartas[x].getPalo() == 3) {
                palo = "Espadas";
            } else {
                palo = "Diamantes";
            }

            String valor = "";
            if (misCartas[x].getValor() == 1) {
                valor = "As";
            } else if (misCartas[x].getValor() == 11) {
                valor = "J";
            } else if (misCartas[x].getValor() == 12) {
                valor = "Q";
            } else if (misCartas[x].getValor() == 13) {
                valor = "K";
            } else {
                valor = misCartas[x].getValor() + "";
            }

            System.out.println("Valor: " + valor + " / Palo: " + palo);
        }
    }
    
    /**
     * método para mostrar las manos enseñando solo una carta del dealer.
     */
    public void mostrarCartasInicio() {
        String palo = "";
        if (misCartas[0].getPalo() == 1) {
            palo = "Corazones";
        } else if (misCartas[0].getPalo() == 2) {
            palo = "Trebol";
        } else if (misCartas[0].getPalo() == 3) {
            palo = "Espadas";
        } else {
            palo = "Diamantes";
        }

        String valor = "";
        if (misCartas[0].getValor() == 1) {
            valor = "As";
        } else if (misCartas[0].getValor() == 11) {
            valor = "J";
        } else if (misCartas[0].getValor() == 12) {
            valor = "Q";
        } else if (misCartas[0].getValor() == 13) {
            valor = "K";
        } else {
            valor = misCartas[0].getValor() + "";
        }

        System.out.println("Valor: " + valor + " / Palo: " + palo);
        System.out.println("Valor: ** / Palo: ******");
    }
}
