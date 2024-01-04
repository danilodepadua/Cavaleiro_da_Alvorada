package com.daniel.PrimeiraCamada;

public abstract class Inimigo extends Personagem{
    int Def, MagicDef, atqF, atqMag;
    public Inimigo(String Nome, String Imagem, int fr, int in, int rs, int vel, int ModDef, int ModMagDef, int ModAtqF, int ModAtqM, int ModHp, int ModMp) {
        super(Nome, Imagem, fr, in, rs, vel);
        this.Def += ModDef;
        this.MagicDef += ModMagDef;
        this.atqF = ModAtqF;
        this.atqMag = ModAtqM;
        this.HP += ModHp;
        this.MP += ModMp;
        this.fraquezas = new TiposDano[0];
        this.resistencias = new TiposDano[0];
        this.imunidades = new TiposDano[0];
        this.absorcao = new TiposDano[0];
    }
    protected TiposDano[] fraquezas;
    protected TiposDano[] resistencias;
    protected TiposDano[] imunidades;
    protected TiposDano[] absorcao;

    public int getDefesaM(){
        return MagicDef;
    }
    public int getDefesaF(){
        return Def;
    }
    public int getAtaqueF(){
        return atqF;
    }
    public int getAtaqueM(){
        return atqMag;
    }
}
