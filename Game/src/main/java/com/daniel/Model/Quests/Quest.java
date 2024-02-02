package com.daniel.Model.Quests;

import com.daniel.Model.Exceptions.PlayerInexistenteException;

import java.io.Serializable;

public abstract class Quest implements Serializable {
    protected String nome;
    protected String descricao;
    protected int recompensaXP;
    protected int recompensaMoedas;
    protected int pontosEvolucao;
    protected int objetivo;
    protected int progresso;
    protected String nomeInimigo;
    public  void updateQuestCompleted() throws PlayerInexistenteException{
        progresso++;
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

    public boolean isCompleta() {
        return progresso >= objetivo;
    }
    public int getObjetivo() {
        return objetivo;
    }

    public String getNomeInimigo() {
        return nomeInimigo;
    }

    public int getProgresso() {
        return progresso;
    }

}
