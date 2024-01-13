package com.daniel.PrimeiraCamada;

import com.daniel.PrimeiraCamada.Exceptions.PlayerInexistenteException;
import com.daniel.PrimeiraCamada.Interfaces.IQuest;

import java.io.Serializable;

public abstract class Quest implements Serializable, IQuest {
    protected String nome;
    protected String descricao;
    protected int recompensaXP;
    protected int recompensaMoedas;
    protected int pontosEvolucao;
    protected int objetivo;
    protected int progresso;
    protected String nomeInimigo;
    private boolean habilitada = true;

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
    @Override
    public  void updateQuestCompleted() throws PlayerInexistenteException{
        progresso++;

        if (isCompleta()) {
            System.out.println("Quest concluída: " + getNome());

        }
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
    public boolean isHabilitada() {
        return habilitada;
    }

    public void setHabilitada(boolean habilitada) {
        this.habilitada = habilitada;
    }
}
