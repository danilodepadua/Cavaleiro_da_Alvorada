package com.daniel.Model.Dados.Entidades.Inimigos;

import com.daniel.Model.Dados.Entidades.Personagem;
import com.daniel.Model.Dados.LootTable;
import com.daniel.Model.ComportamentosInimigos.Comportamentos;
import com.daniel.Model.Magias.TiposElementais;

public abstract class Inimigo extends Personagem {
    int pos,  dropXp, moedas;
    private final Comportamentos comp;
    protected TiposElementais tipoDano;
    protected LootTable lootTable = new LootTable();
    public Inimigo(String Nome, String Imagem, int posicao, int fr, int in, int rs, int vel, int sorte, int ModHp, int ModMp, TiposElementais tipoDn, Comportamentos comp, int dropXp, int moedas) {
        super(Nome, Imagem, fr, in, rs, vel, sorte);
        this.HP = ModHp;
        this.MP = ModMp;
        this.fraquezas = new TiposElementais[0];
        this.resistencias = new TiposElementais[0];
        this.imunidades = new TiposElementais[0];
        this.absorcao = new TiposElementais[0];
        this.tipoDano = tipoDn;
        this.comp = comp;
        this.pos = posicao;
        this.dropXp = dropXp;
        this.moedas = moedas;
    }
    protected TiposElementais[] fraquezas;
    protected TiposElementais[] resistencias;
    protected TiposElementais[] imunidades;
    protected TiposElementais[] absorcao;

    public int getDropXp() {
        return dropXp;
    }

    public int getMoedas() {
        return moedas;
    }

    public int getPos(){return pos;}

    public LootTable getLootTable() {
        return lootTable;
    }

    public Comportamentos getComp() {
        return comp;
    }

    public TiposElementais[] getFraquezas() {
        return fraquezas;
    }

    public TiposElementais[] getResistencias() {
        return resistencias;
    }

    public TiposElementais[] getImunidades() {
        return imunidades;
    }

    public TiposElementais[] getAbsorcao() {
        return absorcao;
    }
}
