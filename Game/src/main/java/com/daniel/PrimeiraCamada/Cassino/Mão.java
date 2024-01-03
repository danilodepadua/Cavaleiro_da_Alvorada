package com.daniel.PrimeiraCamada.Cassino;

import java.util.ArrayList;

public class Mão {
    private ArrayList<Carta> mao;
    private int pontos;

    public Mão() {
        this.pontos = 0;
        this.mao = new ArrayList<Carta>();
    }

    public void addCarta(Carta carta){
        this.pontos += carta.getValor();
        this.mao.add(carta);
    }

    public ArrayList<Carta> getMao() {
        return mao;
    }

    public void setMao(ArrayList<Carta> mao) {
        this.mao = mao;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }
    public boolean temAs() {
        // Verifica se a mão possui pelo menos um Ás
        return mao.stream().anyMatch(carta -> carta.getNome().equals("Ás"));
    }

    public void converterAs() {
        // Encontra o primeiro Ás na mão e converte seu valor de 11 para 1
        for (Carta carta : mao) {
            if (carta.getNome().equals("Ás") && carta.getValor() == 11) {
                carta.setValor(1);
                this.pontos -= 10; // Subtrai 10 pontos para compensar a conversão
                break; // Para ao converter o primeiro Ás encontrado
            }
        }
    }

    public void limparMao() {
        mao.clear();
    }

}
