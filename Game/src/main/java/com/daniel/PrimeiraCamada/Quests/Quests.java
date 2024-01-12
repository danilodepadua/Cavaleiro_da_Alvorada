package com.daniel.PrimeiraCamada.Quests;

import com.daniel.PrimeiraCamada.Entidades.Player;
import com.daniel.PrimeiraCamada.Exceptions.PlayerInexistenteException;
import com.daniel.PrimeiraCamada.Inimigo;

import java.io.Serializable;

public  class Quests implements Serializable {
    private String nome;
    private String descricao;
    private int recompensaXP;
    private int recompensaMoedas;
    private int pontosEvolucao;
    private int objetivo;
    private int progresso;
    public Quests(String nome, String descricao, int recompensaXP, int recompensaMoedas, int pontosEvolucao, int objetivo) {
        this.nome = nome;
        this.descricao = descricao;
        this.recompensaXP = recompensaXP;
        this.recompensaMoedas = recompensaMoedas;
        this.pontosEvolucao = pontosEvolucao;
        this.progresso = 0;
        this.objetivo = objetivo;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getRecompensaXP() {
        return recompensaXP;
    }

    public int getRecompensaMoedas() {
        return recompensaMoedas;
    }

    public int getPontosEvolucao() {
        return pontosEvolucao;
    }

    public  void updateQuestCompleted() throws PlayerInexistenteException{
        progresso++;

        if (progresso >= objetivo) {
            System.out.println("Quest concluída: " + getNome());
            Player.getPlayer().setPontos(this.getPontosEvolucao());
            Player.getPlayer().ganhaCoins(this.getRecompensaMoedas());
            Player.getPlayer().ganharXp(getRecompensaXP());
        }
    }

    public int getObjetivo() {
        return objetivo;
    }


    public int getProgresso() {
        return progresso;
    }
}
