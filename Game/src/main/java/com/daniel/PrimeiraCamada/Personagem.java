package com.daniel.PrimeiraCamada;

import javafx.scene.image.Image;

import java.io.Serializable;

public abstract class Personagem implements Serializable {
    protected int HP = 0;
    protected int currentHP = 0;
    protected int MP = 0;
    protected int currentMP = 0;
    protected String Name = null;
    protected int Force = 0;
    protected int Velocity = 0;
    protected int MagicDef = 0;
    protected int Def = 0;
    protected int Inteligence = 0;
    protected int Resistencia = 0;

    public int getHP() {
        return HP;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public int getMP() {
        return MP;
    }

    public int getCurrentMP() {
        return currentMP;
    }

    public String getName() {
        return Name;
    }

    public int getForce() {
        return Force;
    }

    public int getVelocity() {
        return Velocity;
    }

    public int getMagicDef() {
        return MagicDef;
    }

    public int getDef() {
        return Def;
    }

    public int getInteligence() {
        return Inteligence;
    }
    public int getResistencia(){return Resistencia;}

    public void RecuperarVida(int i){
        this.currentHP += i;
        if(this.currentHP > this.HP){
            this.currentHP = this.HP;
        }
    }

    public void aumentarDefesa(int aumento){
        this.Def += aumento;
    }
    public void diminuirDefesa(int diminuicao) {
        this.Def -= diminuicao;
        if (this.Def < 0) {
            this.Def = 0;
        }
    }

    public void RecuperarMp(int i){
        this.currentMP += i;
        if(this.currentMP > this.MP){
            this.currentMP = this.MP;
        }
    }
}
