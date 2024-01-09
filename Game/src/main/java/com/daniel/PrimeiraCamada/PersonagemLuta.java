package com.daniel.PrimeiraCamada;

import com.daniel.PrimeiraCamada.Entidades.Player;
import com.daniel.SegundaCamada.AnimationsAttack;
import com.daniel.SegundaCamada.SlashAnimation;

import java.util.ArrayList;
import java.util.Random;

public class PersonagemLuta{

    protected String Nome;
    protected AnimationsAttack atqAnim;
    protected ArrayList<Magia> magias;
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
        this.Nome = i.getName();
        this.magias = i.magias;
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
        this.fraquezas = new TiposElementais[0];
        this.resistencias = new TiposElementais[0];
        this.imunidades = new TiposElementais[0];
        this.absorcao = new TiposElementais[0];
        this.tipoAtaqueBase = p.getArma().getTipoDano();
        this.atqAnim = new SlashAnimation();
        this.Nome = p.getName();
        this.magias = p.magias;
    }
    protected TiposElementais[] fraquezas;
    protected TiposElementais[] resistencias;
    protected TiposElementais[] imunidades;
    protected TiposElementais[] absorcao;
    protected TiposElementais tipoAtaqueBase;

    public int tomarDano(int dano, TiposElementais tipo, boolean fisico){
        int danoTomado = 0;
        if(temTipo(fraquezas, tipo)){
            if(!fisico){
                danoTomado = dano*2 - this.getDefM();
                if(danoTomado <0){
                    danoTomado = 0;
                }
                this.currentHp -= danoTomado;
            }
            else{
                danoTomado = dano*2 - this.getDefF();
                if(danoTomado <0){
                    danoTomado = 0;
                }
                this.currentHp -= danoTomado;
            }
        }
        else if(temTipo(resistencias, tipo)){
            if(!fisico){
                danoTomado = dano/2 - this.getDefM();
                if(danoTomado <0){
                    danoTomado = 0;
                }
                this.currentHp -= danoTomado;
            }
            else{
                danoTomado = dano/2 - this.getDefF();
                if(danoTomado <0){
                    danoTomado = 0;
                }
                this.currentHp -= danoTomado;
            }
        }
        else if(temTipo(absorcao, tipo)){
            danoTomado = -dano/2;
            this.currentHp -= danoTomado;
        }
        else if(!temTipo(imunidades, tipo)){
            if(!fisico){
                danoTomado = dano - this.getDefM();
                if(danoTomado <0){
                    danoTomado = 0;
                }
                this.currentHp -= danoTomado;
            }
            else{
                danoTomado = dano - this.getDefF();
                if(danoTomado <0){
                    danoTomado = 0;
                }
                this.currentHp -= danoTomado;
            }
        }
        return danoTomado;
    }
    public void usarMp(int i){
        this.currentMp -= i;
        if(this.currentMp <0){
            this.currentMp = 0;
        }
    }

    public boolean temTipo(TiposElementais[] tipos, TiposElementais tipo){
        for(TiposElementais T : tipos){
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

    public AnimationsAttack getAtqAnim() {
        return atqAnim;
    }

    public ArrayList<Magia> getMagias() {
        return magias;
    }

    public int getHP() {
        return HP;
    }

    public int getMP() {
        return MP;
    }

    public TiposElementais getTipoAtaqueBase() {
        return tipoAtaqueBase;
    }

    public String getNome() {
        return Nome;
    }

    public void UpForca(int Up){
        this.AtqF += Up;
    }
    public void RecuperarMana(int i) {
        this.currentMp += i;
        if(currentMp > MP){
            currentMp = MP;
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
    public boolean fugir(int velC){
        Random rand = new Random();
        return !(velC * rand.nextDouble(0.5, 1.5) > this.velocidade);
    }
}
