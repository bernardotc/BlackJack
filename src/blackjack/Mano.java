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

    public Mano(Mazo m) {
        mazo = m;
        suma = 0;
        misCartas = new Carta[10];
    }

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

    public int getSuma() {
        return suma;
    }

    public void setSuma(int s) {
        suma = s;
    }

    public int getCantidadCartas() {
        return cantidadCartas;
    }

    public void setCantidadCartas(int c) {
        cantidadCartas = c;
    }

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
}
