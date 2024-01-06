package com.daniel.PrimeiraCamada;

import com.daniel.PrimeiraCamada.Entidades.Player;

public class PersonagemLuta{

    protected int currentHp, currentMp, HP, MP, DefF, DefM, AtqM, AtqF, velocidade, stun = 0;
    public PersonagemLuta(Inimigo i){
        this.HP = i.HP;
        this.MP = i.MP;
        this.currentHp = HP;
        this.currentMp = MP;
        this.DefF = i.getDefesaF();
        this.DefM = i.getDefesaM();
        this.AtqF = i.getAtaqueF();
        this.AtqM = i.getAtaqueM();
        this.velocidade = i.getVelocity();
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
        this.velocidade = p.getVelocity();
        this.fraquezas = new TiposDano[0];
        this.resistencias = new TiposDano[0];
        this.imunidades = new TiposDano[0];
        this.absorcao = new TiposDano[0];
        this.tipoAtaqueBase = p.getArma().getTipoDano();
    }
    protected TiposDano[] fraquezas;
    protected TiposDano[] resistencias;
    protected TiposDano[] imunidades;
    protected TiposDano[] absorcao;
    protected TiposDano tipoAtaqueBase;

    public int tomarDano(int dano, TiposDano tipo){
        if(temTipo(fraquezas, tipo)){
            this.currentHp -= dano*2;
            return dano*2;
        }
        else if(temTipo(resistencias, tipo)){
            this.currentHp -= dano/2;
            return dano/2;
        }
        else if(temTipo(absorcao, tipo)){
            this.currentHp += dano/2;
            if(this.currentHp > this.HP){
                this.currentHp = this.HP;
            }
            return dano/2;
        }
        else if(!temTipo(imunidades, tipo)){
            this.currentHp -= dano;
            return dano;
        }
        return 0;
    }

    public boolean temTipo(TiposDano[] tipos, TiposDano tipo){
        for(TiposDano T : tipos){
            if(T == tipo){
                return true;
            }
        }
        return false;
    }

    public int getCurrentHp() {
        return currentHp;
    }

    public int getCurrentMp() {
        return currentMp;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public int getStun() {
        return stun;
    }

    public int getDefF() {
        return DefF;
    }

    public int getDefM() {
        return DefM;
    }

    public int getAtqM() {
        return AtqM;
    }

    public int getAtqF() {
        return AtqF;
    }

    public TiposDano getTipoAtaqueBase() {
        return tipoAtaqueBase;
    }


    public void UpForca(int Up){
        this.AtqF += Up;
    }
    public void RecuperarMana(int i) {
        this.currentMp += i;
        if(currentMp > MP){
            currentMp = 0;
        }
    }
    public void RecuperarVida(int i){
        this.currentHp += i;
        if(this.currentHp > this.HP){
            this.currentHp = this.HP;
        }
    }

    public void reduzirDefesaMagica(int diminuicao) {
        DefM -= diminuicao;
        if (DefM < 0) {
            DefM = 0;
        }
    }

    public void aplicarStun(){
        stun++;
    }
}
