package com.daniel.Dados.CassinoRepositorio;

import com.daniel.Modelo.Cassino.Carta;
import com.daniel.Modelo.Exceptions.BaralhoVazioException;

import java.util.ArrayList;
import java.util.Collections;

public class Baralho {
    private ArrayList<Carta> cartas = new ArrayList<>();

    public Baralho() {
    }

    public void embaralhar() {
        Collections.shuffle(cartas);
    }

    public Carta pegarCarta() throws BaralhoVazioException {
        if (!cartas.isEmpty()) {
            return cartas.remove(cartas.size() - 1);
        } else {
            throw new BaralhoVazioException();
        }
    }


    public void reiniciarBaralho() {
        // Limpa e reinicia o baralho
        cartas.clear();
        // Adicione as cartas novamente
        criarBaralho("hearts");
        criarBaralho("clubs");
        criarBaralho("spades");
        criarBaralho("diamonds");
    }
    public void reiniciarBaralhoPoker() {
        // Limpa e reinicia o baralho
        cartas.clear();
        // Adicione as cartas novamente
        criarBaralhoPoker("hearts");
        criarBaralhoPoker("clubs");
        criarBaralhoPoker("spades");
        criarBaralhoPoker("diamonds");
    }
    public void reiniciarBaralhoMemoria() {
        // Limpa e reinicia o baralho
        cartas.clear();

        // Adicione as cartas novamente
        criarBaralhoMemoria();
    }

    public boolean vazio() {
        return cartas.isEmpty();
    }

    public int tamanho() {
        return cartas.size();
    }
    public void criarBaralhoMemoria(){
        String naipe = "hearts";

        // Ás
        Carta carta1 = new Carta("Ás", naipe, 1, "/com.daniel.Images/Cartas/ace_of_hearts.png");
        Carta carta12 = new Carta("Ás", naipe, 1, "/com.daniel.Images/Cartas/ace_of_hearts.png");

        // Dois
        Carta carta2 = new Carta("Dois", naipe, 2, "/com.daniel.Images/Cartas/two_of_hearts.png");
        Carta carta21 = new Carta("Dois", naipe, 2, "/com.daniel.Images/Cartas/two_of_hearts.png");

        // Três
        Carta carta3 = new Carta("Três", naipe, 3, "/com.daniel.Images/Cartas/three_of_hearts.png");
        Carta carta31 = new Carta("Três", naipe, 3, "/com.daniel.Images/Cartas/three_of_hearts.png");

        // Quatro
        Carta carta4 = new Carta("Quatro", naipe, 4, "/com.daniel.Images/Cartas/four_of_hearts.png");
        Carta carta41 = new Carta("Quatro", naipe, 4, "/com.daniel.Images/Cartas/four_of_hearts.png");

        // Cinco
        Carta carta5 = new Carta("Cinco", naipe, 5, "/com.daniel.Images/Cartas/five_of_hearts.png");
        Carta carta51 = new Carta("Cinco", naipe, 5, "/com.daniel.Images/Cartas/five_of_hearts.png");

        // Seis
        Carta carta6 = new Carta("Seis", naipe, 6, "/com.daniel.Images/Cartas/six_of_hearts.png");
        Carta carta61 = new Carta("Seis", naipe, 6, "/com.daniel.Images/Cartas/six_of_hearts.png");

        // Sete
        Carta carta7 = new Carta("Sete", naipe, 7, "/com.daniel.Images/Cartas/seven_of_hearts.png");
        Carta carta71 = new Carta("Sete", naipe, 7, "/com.daniel.Images/Cartas/seven_of_hearts.png");

        // Oito
        Carta carta8 = new Carta("Oito", naipe, 8, "/com.daniel.Images/Cartas/eight_of_hearts.png");
        Carta carta81 = new Carta("Oito", naipe, 8, "/com.daniel.Images/Cartas/eight_of_hearts.png");

        // Nove
        Carta carta9 = new Carta("Nove", naipe, 9, "/com.daniel.Images/Cartas/nine_of_hearts.png");
        Carta carta91 = new Carta("Nove", naipe, 9, "/com.daniel.Images/Cartas/nine_of_hearts.png");

        // Adicione as cartas à sua estrutura de dados, como uma lista de cartas no seu baralho.
        cartas.add(carta1);
        cartas.add(carta12);
        cartas.add(carta2);
        cartas.add(carta21);
        cartas.add(carta3);
        cartas.add(carta31);
        cartas.add(carta4);
        cartas.add(carta41);
        cartas.add(carta5);
        cartas.add(carta51);
        cartas.add(carta6);
        cartas.add(carta61);
        cartas.add(carta7);
        cartas.add(carta71);
        cartas.add(carta8);
        cartas.add(carta81);
        cartas.add(carta9);
        cartas.add(carta91);

    }
    public void criarBaralho(String naipe) {
        for (int valor = 2; valor <= 10; valor++) {
            String valorCarta = obterNomeCarta(valor);
            String caminho = "/com.daniel.Images/Cartas/" + valorCarta + "_of_" + naipe.toLowerCase() + ".png";
            cartas.add(new Carta(valorCarta, naipe, valor, caminho));
        }

        // Adiciona Ás, Valete, Dama e Rei
        cartas.add(new Carta("Ás", naipe, 11, "/com.daniel.Images/Cartas/ace_of_" + naipe.toLowerCase() + ".png"));
        cartas.add(new Carta("Valete", naipe, 10, "/com.daniel.Images/Cartas/jack_of_" + naipe.toLowerCase() + ".png"));
        cartas.add(new Carta("Dama", naipe, 10, "/com.daniel.Images/Cartas/queen_of_" + naipe.toLowerCase() + ".png"));
        cartas.add(new Carta("Rei", naipe, 10, "/com.daniel.Images/Cartas/king_of_" + naipe.toLowerCase() + ".png"));

    }
    public void criarBaralhoPoker(String naipe) {
        for (int valor = 2; valor <= 10; valor++) {
            String valorCarta = obterNomeCarta(valor);
            String caminho = "/com.daniel.Images/Cartas/" + valorCarta + "_of_" + naipe.toLowerCase() + ".png";
            cartas.add(new Carta(valorCarta, naipe, valor, caminho));
        }

        // Adiciona Ás, Valete, Dama e Rei
        cartas.add(new Carta("Ás", naipe, 1, "/com.daniel.Images/Cartas/ace_of_" + naipe.toLowerCase() + ".png"));
        cartas.add(new Carta("Valete", naipe, 11, "/com.daniel.Images/Cartas/jack_of_" + naipe.toLowerCase() + ".png"));
        cartas.add(new Carta("Dama", naipe, 12, "/com.daniel.Images/Cartas/queen_of_" + naipe.toLowerCase() + ".png"));
        cartas.add(new Carta("Rei", naipe, 13, "/com.daniel.Images/Cartas/king_of_" + naipe.toLowerCase() + ".png"));

    }
    private String obterNomeCarta(int valor) {
        switch (valor) {
            case 2: return "two";
            case 3: return "three";
            case 4: return "four";
            case 5: return "five";
            case 6: return "six";
            case 7: return "seven";
            case 8: return "eight";
            case 9: return "nine";
            case 10: return "ten";
            default: return String.valueOf(valor);
        }
    }

}
