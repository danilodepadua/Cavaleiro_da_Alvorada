package com.daniel.Controller;

import com.daniel.Model.Cassino.Poker;
import com.daniel.Model.Dados.CassinoRepositorio.Mão;
import com.daniel.Model.Cassino.Carta;

import java.util.*;

public class AvaliadorPoker {
    private static AvaliadorPoker instance;
    private Poker poker;

    // Construtor privado para evitar instanciação direta
    private AvaliadorPoker() {
        poker = new Poker();
    }

    // Método público para obter a instância única da classe singleton
    public static  AvaliadorPoker getInstance() {
        if (instance == null) {
            instance = new AvaliadorPoker();
        }
        return instance;
    }

    public  String avaliarMao(Mão mao, Mão centro){
        return poker.avaliarMao(mao, centro);
    }

    public  int avaliarForcaMao(Mão mao, Mão centro) {
        return poker.avaliarForcaMao(mao, centro);
    }


    }
