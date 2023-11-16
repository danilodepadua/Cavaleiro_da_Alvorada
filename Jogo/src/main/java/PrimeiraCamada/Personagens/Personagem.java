package PrimeiraCamada.Personagens;

import com.almasb.fxgl.texture.AnimatedTexture;

abstract class Personagem {
    private String nome;
    private int hp;
    private int dano;
    private int defesa;

    private AnimatedTexture texture;


    public void setStats(String nome,  int hp, int dano, int defesa) {
        this.nome = nome;
        this.hp = hp;
        this.dano= dano;
        this.defesa = defesa;
    }


}
