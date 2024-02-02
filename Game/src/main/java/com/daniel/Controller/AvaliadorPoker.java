package com.daniel.Controller;

import com.daniel.Model.Dados.CassinoRepositorio.Mão;
import com.daniel.Model.Cassino.Carta;

import java.util.*;

public class AvaliadorPoker {
    private static AvaliadorPoker instance;

    // Construtor privado para evitar instanciação direta
    private AvaliadorPoker() {
    }

    // Método público para obter a instância única da classe singleton
    public static synchronized AvaliadorPoker getInstance() {
        if (instance == null) {
            instance = new AvaliadorPoker();
        }
        return instance;
    }

    public  String avaliarMao(Mão mao, Mão centro) {
        if (temRoyalFlush(mao, centro)) {
            return "Royal Flush";
        } else if (temStraightFlush(mao, centro)) {
            return "Straight Flush";
        } else if (temFourOfAKind(mao, centro)) {
            return "Four of a Kind";
        } else if (temFullHouse(mao, centro)) {
            return "Full House";
        } else if (temFlush(mao, centro)) {
            return "Flush";
        } else if (temStraight(mao, centro)) {
            return "Straight";
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

    public  int avaliarForcaMao(Mão mao, Mão centro) {
        if (temRoyalFlush(mao, centro)) {
            return 11;
        } else if (temStraightFlush(mao, centro)) {
            return 10;
        } else if (temFourOfAKind(mao, centro)) {
            return 9;
        } else if (temFullHouse(mao, centro)) {
            return 8;
        } else if (temFlush(mao,centro)) {
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
    private static boolean temRoyalFlush(Mão mao, Mão centro) {
        // Verifica se a mão tem um Ás, um Valete, uma Dama, um Rei e um 10, todos do mesmo naipe
        int valorCartaMao1 = mao.getMao().get(0).getValor();
        int valorCartaMao2 = mao.getMao().get(1).getValor();
        String naipeMao1 = mao.getMao().get(0).getNaipe();
        String naipeMao2 = mao.getMao().get(1).getNaipe();

        boolean temDez = false;
        boolean temValete = false;
        boolean temDama = false;
        boolean temRei = false;
        boolean temAs = false;

        // Verificar se as cartas da mão têm os valores e naipes corretos
        if (valorCartaMao1 == 1 && naipeMao1.equals(naipeMao2)) {
            temAs = true;
        }
        if (valorCartaMao1 == 10 && naipeMao1.equals(naipeMao2)) {
            temDez = true;
        }
        if (valorCartaMao1 == 11 && naipeMao1.equals(naipeMao2)) {
            temValete = true;
        }
        if (valorCartaMao1 == 12 && naipeMao1.equals(naipeMao2)) {
            temDama = true;
        }
        if (valorCartaMao1 == 13 && naipeMao1.equals(naipeMao2)) {
            temRei = true;
        }

        // Verificar se as duas cartas iniciais são válidas para um Royal Flush
        if ((temAs && temDez && temValete && temDama && temRei) || (valorCartaMao2 == 1 && temDez && temValete && temDama && temRei)) {
            // As duas cartas iniciais são válidas, agora verificar se o centro tem o restante para completar a sequência
            List<Integer> valores = Arrays.asList(1, 10, 11, 12, 13);

            for (Carta carta : centro.getMao()) {
                if (naipeMao1.equals(carta.getNaipe()) && valores.contains(carta.getValor())) {
                    valores.remove(Integer.valueOf(carta.getValor()));
                }
            }

            return valores.isEmpty(); // Se a lista de valores estiver vazia, significa que o Royal Flush está completo
        }

        return false;
    }

    private static boolean temStraightFlush(Mão mao, Mão centro) {
        int valorCartaMao1 = mao.getMao().get(0).getValor();
        int valorCartaMao2 = mao.getMao().get(1).getValor();
        String naipeMao1 = mao.getMao().get(0).getNaipe();
        String naipeMao2 = mao.getMao().get(1).getNaipe();

        // Verificar se as cartas da mão são do mesmo naipe
        if (naipeMao1.equals(naipeMao2)) {
            // Ordenar os valores das cartas da mão e adicionar os valores do centro
            List<Integer> valores = new ArrayList<>();
            valores.add(valorCartaMao1);
            valores.add(valorCartaMao2);

            for (Carta carta : centro.getMao()) {
                valores.add(carta.getValor());
            }

            // Ordenar os valores
            Collections.sort(valores);

            // Verificar se existem cinco cartas consecutivas do mesmo naipe
            int contadorConsecutivas = 1;

            for (int i = 0; i < valores.size() - 1; i++) {
                int valorAtual = valores.get(i);
                int valorProximo = valores.get(i + 1);

                if (valorProximo - valorAtual == 1) {
                    contadorConsecutivas++;
                    if (contadorConsecutivas == 5) {
                        return true; // Encontrou um Straight Flush
                    }
                } else if (valorProximo != valorAtual) {
                    contadorConsecutivas = 1; // Reiniciar contador se houver lacuna entre cartas
                }
            }
        }

        return false;
    }

    private static boolean temFourOfAKind(Mão mao, Mão centro) {
        int valorCartaMao1 = mao.getMao().get(0).getValor();
        int valorCartaMao2 = mao.getMao().get(1).getValor();

        if (valorCartaMao1 == valorCartaMao2){
            int contador = 0;

            for (Carta carta : centro.getMao()){
                if (valorCartaMao1== carta.getValor()){
                    contador++;
                }

                if (contador ==2){
                    return true;
                }
            }
        }
        return false;
    }


    private static boolean temFullHouse(Mão mao, Mão centro) {
        int valorCartaMao1 = mao.getMao().get(0).getValor();
        int valorCartaMao2 = mao.getMao().get(1).getValor();

        int contadorCartaMao1 = 0;
        int contadorCartaMao2 = 0;

        // Verificar se a primeira carta da mão forma um trinca no centro e a segunda forma um par
        for (Carta carta : centro.getMao()) {
            if (valorCartaMao1 == carta.getValor()) {
                contadorCartaMao1++;
            }
            if (valorCartaMao2 == carta.getValor()) {
                contadorCartaMao2++;
            }
        }

        if ((contadorCartaMao1 == 2 && contadorCartaMao2 == 1) || (contadorCartaMao1 == 1 && contadorCartaMao2 == 2)) {
            return true;
        }

        // Resetar contadores para o segundo caso
        contadorCartaMao1 = 0;
        contadorCartaMao2 = 0;

        // Verificar se a segunda carta da mão forma um trinca no centro e a primeira forma um par
        for (Carta carta : centro.getMao()) {
            if (valorCartaMao2 == carta.getValor()) {
                contadorCartaMao2++;
            }
            if (valorCartaMao1 == carta.getValor()) {
                contadorCartaMao1++;
            }
        }

        return (contadorCartaMao2 == 2 && contadorCartaMao1 == 1) || (contadorCartaMao2 == 1 && contadorCartaMao1 == 2);
    }


    private static boolean temFlush(Mão mao, Mão centro) {
        String naipeMao1 = mao.getMao().get(0).getNaipe();
        String naipeMao2 = mao.getMao().get(1).getNaipe();

        if (naipeMao1.equals(naipeMao2)) {
            int contador = 0;

            for (Carta carta : centro.getMao()) {
                if (carta.getNaipe().equals(naipeMao1)) {
                    contador++;
                }
                if (contador == 3) {
                    return true; // Encontrou um Flush
                }
            }
        }

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

        // Ordenar os valores
        Collections.sort(valores);

        // Inserir as cartas da mão nas posições apropriadas (meio da sequência)
        int indiceInsercaoMao1 = Collections.binarySearch(valores, valorCartaMao1);
        int indiceInsercaoMao2 = Collections.binarySearch(valores, valorCartaMao2);

        // Se as cartas não estiverem na sequência, não pode ser um Straight
        if (indiceInsercaoMao1 < 0 || indiceInsercaoMao2 < 0) {
            return false;
        }

        // Adicionar as cartas da mão nas posições encontradas
        valores.add(indiceInsercaoMao1, valorCartaMao1);
        valores.add(indiceInsercaoMao2, valorCartaMao2);

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
            } else {
                contadorConsecutivas = 1; // Reiniciar contador se houver lacuna entre cartas
            }
        }

        return false; // Nenhum Straight encontrado
    }





    private static boolean temThreeOfAKind(Mão mao, Mão centro) {
        int valorCartaMao1 = mao.getMao().get(0).getValor();
        int valorCartaMao2 = mao.getMao().get(1).getValor();

        int contadorCartaMao1 = 0;
        int contadorCartaMao2 = 0;

        for (Carta cartaCentro : centro.getMao()) {
            if (valorCartaMao1 == cartaCentro.getValor()) {
                contadorCartaMao1++;
                if (contadorCartaMao1 == 2) {
                    return true; // Encontrou Three of a Kind
                }
            } else if (valorCartaMao2 == cartaCentro.getValor()) {
                contadorCartaMao2++;
                if (contadorCartaMao2 == 2) {
                    return true; // Encontrou Three of a Kind
                }
            }
        }
        // Verifica se as duas cartas da mão são iguais
        if (valorCartaMao1 == valorCartaMao2) {
            int contadorCartasIguais = 0;
            for (Carta cartaCentro : centro.getMao()) {
                if (valorCartaMao1 == cartaCentro.getValor()) {
                    contadorCartasIguais++;
                    if (contadorCartasIguais == 2) {
                        return true; // Encontrou Three of a Kind
                    }
                }
            }
        }
        return false;
    }




    private static boolean temTwoPair(Mão mao, Mão cartasCentro) {
        int valorCartaMao1 = mao.getMao().get(0).getValor();
        int valorCartaMao2 = mao.getMao().get(1).getValor();

        boolean temPar1 = false;
        boolean temPar2 = false;

        for (Carta cartaCentro : cartasCentro.getMao()) {
            if (valorCartaMao1 == cartaCentro.getValor()) {
                temPar1 = true;
            } else if (valorCartaMao2 == cartaCentro.getValor()) {
                temPar2 = true;
            }
        }

        return temPar1 && temPar2;
    }


    private static boolean temOnePair(Mão mao, Mão cartasCentro) {
        // Verificar se há um par entre as duas primeiras cartas
        int valorCarta0 = mao.getMao().get(0).getValor();
        int valorCarta1 = mao.getMao().get(1).getValor();

        // Verificar se Two Pair já foi encontrado
        if (temTwoPair(mao, cartasCentro)) {
            return false;  // Ignorar a verificação de One Pair
        }
        if (valorCarta0 == valorCarta1){
            return true;
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
