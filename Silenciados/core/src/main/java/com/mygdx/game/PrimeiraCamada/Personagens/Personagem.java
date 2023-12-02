package com.mygdx.game.PrimeiraCamada.Personagens;

abstract class Personagem {
    private String nome;
    private int hp;
    private int dano;
    private int defesa;


    public Personagem(String nome,  int hp, int dano, int defesa) {
        this.nome = nome;
        this.hp = hp;
        this.dano= dano;
        this.defesa = defesa;
    }


}
