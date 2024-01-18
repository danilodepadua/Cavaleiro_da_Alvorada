package com.daniel.PrimeiraCamada.Cassino;

import com.daniel.SegundaCamada.CassinoRepositorio.Baralho;
import com.daniel.SegundaCamada.CassinoRepositorio.Mão;

import java.util.*;

public class AvaliadorPoker {

    public static String avaliarMao(Mão mao, Mão centro) {
        if (temRoyalFlush(mao)) {
            return "Royal Flush";
        } else if (temFourOfAKind(mao)) {
            return "Four of a Kind";
        } else if (temFullHouse(mao)) {
            return "Full House";
        } else if (temFlush(mao)) {
            return "Flush";
        } else if (temStraight(mao, centro)) {
            return "Straight";
        } else if (temRoyalFlush(mao)) {
            return "Royal Flush";
        } else if (temThreeOfAKind(mao, centro)) {
            return "Three of a Kind";
        } else if (temTwoPair(mao, centro)) {
            return "Two Pair";
        } else if (temOnePair(mao, centro)) {
            return  "One Pair";
        } else {
            return "High Card";
        }
    }

    public static int avaliarForcaMao(Mão mao, Mão centro) {
        if (temRoyalFlush(mao)) {
            return 10;
        } else if (temFourOfAKind(mao)) {
            return 9;
        } else if (temFullHouse(mao)) {
            return 8;
        } else if (temFlush(mao)) {
            return 7;
        } else if (temStraight(mao, centro)) {
            return 6;
        } else if (temThreeOfAKind(mao, centro)) {
            return 5;
        } else if (temTwoPair(mao, centro)) {
            return 4;
        } else if (temOnePair(mao, centro)) {
            return 3;
        } else {
            return 2;
        }
    }

    // Implemente os métodos específicos para verificar cada tipo de combinação
    private static boolean temRoyalFlush(Mão mao) {
        // Verifica se a mão tem um Ás, um Valete, uma Dama, um Rei e um 10, todos do mesmo naipe
        boolean temDez = false;
        boolean temValete = false;
        boolean temDama = false;
        boolean temRei = false;
        boolean temAs = false;

        for (Carta carta : mao.getMao()) {
            if (carta.getNome().equals("10")) {
                temDez = true;
            } else if (carta.getNome().equals("Valete")) {
                temValete = true;
            } else if (carta.getNome().equals("Dama")) {
                temDama = true;
            } else if (carta.getNome().equals("Rei")) {
                temRei = true;
            } else if (carta.getNome().equals("Ás")) {
                temAs = true;
            }
        }

        // Retorna true se todas as cartas necessárias estiverem presentes
        return temDez && temValete && temDama && temRei && temAs;
    }

    private static boolean temFourOfAKind(Mão mao) {

        return false;
    }


    private static boolean temFullHouse(Mão mao) {

        return false;
    }

    private static boolean temFlush(Mão mao) {
        return false;
    }


    private static boolean temStraight(Mão mao, Mão centro) {
        // Obter valores das duas cartas da mão
        int valorCartaMao1 = mao.getMao().get(0).getValor();
        int valorCartaMao2 = mao.getMao().get(1).getValor();

        // Adicionar valores das cartas do centro
        List<Integer> valores = new ArrayList<>();
        for (Carta carta : centro.getMao()) {
            valores.add(carta.getValor());
        }

        // Adicionar valores das cartas da mão
        valores.add(valorCartaMao1);
        valores.add(valorCartaMao2);

        // Ordenar os valores
        Collections.sort(valores);

        // Contador para rastrear cartas consecutivas
        int contadorConsecutivas = 1;

        // Verificar se existem cinco cartas consecutivas
        for (int i = 0; i < valores.size() - 1; i++) {
            int valorAtual = valores.get(i);
            int valorProximo = valores.get(i + 1);

            if (valorProximo - valorAtual == 1) {
                contadorConsecutivas++;
                if (contadorConsecutivas == 5) {
                    return true; // Encontrou um Straight
                }
            } else if (valorProximo != valorAtual) {
                contadorConsecutivas = 1; // Reiniciar contador se houver lacuna entre cartas
            }
        }

        return false; // Nenhum Straight encontrado
    }



    private static boolean temThreeOfAKind(Mão mao, Mão centro) {
        int valorCartaMao1 = mao.getMao().get(0).getValor();
        int valorCartaMao2 = mao.getMao().get(1).getValor();

        int contador = 0;
        for (Carta carta : centro.getMao()){
            if (valorCartaMao1 == carta.getValor()){
                contador++;
            } else if (valorCartaMao2 == carta.getValor()) {
                contador++;
            }
        }
        return contador >=3;
    }


    private static boolean temTwoPair(Mão mao, Mão cartasCentro) {
        // Obter valores das duas cartas da mão
        int valorCartaMao1 = mao.getMao().get(0).getValor();
        int valorCartaMao2 = mao.getMao().get(1).getValor();

        int contador = 0;
        for (Carta carta : cartasCentro.getMao()){
            if (valorCartaMao1 == carta.getValor()){
                contador++;
            } else if (valorCartaMao2 == carta.getValor()) {
                contador++;
            }
        }
        return contador >=2;
    }


    private static boolean temOnePair(Mão mao, Mão cartasCentro) {
        // Verificar se há um par entre as duas primeiras cartas
        int valorCarta0 = mao.getMao().get(0).getValor();
        int valorCarta1 = mao.getMao().get(1).getValor();

        // Verificar se Two Pair já foi encontrado
        if (temTwoPair(mao, cartasCentro)) {
            return false;  // Ignorar a verificação de One Pair
        }

        // Verificar se há um par com as cartas no centro
        for (Carta carta : cartasCentro.getMao()) {
            if (valorCarta0 == carta.getValor() || valorCarta1 == carta.getValor()) {
                return true; // Encontrou um par com as cartas no centro
            }
        }

        return false; // Nenhum par encontrado
    }



}
