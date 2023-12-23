package com.daniel.PrimeiraCamada.Inimigos;

import com.daniel.PrimeiraCamada.IFightable;
import com.daniel.PrimeiraCamada.Personagem;

public class InimigoExemplo1 extends Personagem implements IFightable {

    public InimigoExemplo1(){
        this.Name = "Inimigo Simples";
        this.HP = 100;
        this.currentHP = this.HP;
        this.MP = 50;
        this.currentMP = this.MP;
        this.Force = 10;
        this.Def = 5;
        this.Inteligence = 3;
        this.MagicDef = 20;
        this.Velocity = 5;
    }
    @Override
    public void Atacado(int Quant) {
        this.HP -= Quant;
    }

    @Override
    public void Atacar(Personagem Alvo) {

    }
}
