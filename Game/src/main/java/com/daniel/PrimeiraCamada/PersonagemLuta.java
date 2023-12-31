package com.daniel.PrimeiraCamada;

import com.daniel.PrimeiraCamada.Entidades.Player;

public abstract class PersonagemLuta{

    protected int currentHp, currentMp, HP, MP, DefF, DefM, AtqM, AtqF;
    public PersonagemLuta(Inimigo i){
        this.HP = i.HP;
        this.MP = i.MP;
        this.DefF = i.getDefesaF();
        this.DefM = i.getDefesaM();
        this.AtqF = i.getAtaqueF();
        this.AtqM = i.getAtaqueM();
        this.fraquezas = i.fraquezas;
        this.resistencias = i.resistencias;
        this.imunidades = i.imunidades;
        this.absorcao = i.absorcao;
    }
    public PersonagemLuta(Player p){
        this.DefF = p.getDefesaF();
        this.DefM = p.getDefesaM();
        this.AtqM = p.getAtaqueM();
        this.AtqF = p.getAtaqueF();
        this.HP = p.getHP();
        this.MP = p.getMP();
        this.currentHp = p.getcHP();
        this.currentMp = p.getcMp();
        this.fraquezas = new TiposDano[0];
        this.resistencias = new TiposDano[0];
        this.imunidades = new TiposDano[0];
        this.absorcao = new TiposDano[0];
    }
    protected TiposDano[] fraquezas;
    protected TiposDano[] resistencias;
    protected TiposDano[] imunidades;
    protected TiposDano[] absorcao;

    public void tomarDano(int dano, TiposDano tipo){
        if(temTipo(fraquezas, tipo)){
            this.currentHp -= dano*2;
        }
        else if(temTipo(resistencias, tipo)){
            this.currentHp -= dano/2;
        }
        else if(temTipo(absorcao, tipo)){
            this.currentHp += dano/2;
            if(this.currentHp > this.HP){
                this.currentHp = this.HP;
            }
        }
        else if(!temTipo(imunidades, tipo)){
            this.currentHp -= dano;
        }
    }

    public boolean temTipo(TiposDano[] tipos, TiposDano tipo){
        for(TiposDano T : tipos){
            if(T == tipo){
                return true;
            }
        }
        return false;
    }
}
