package com.daniel.PrimeiraCamada;

public abstract class Inimigo extends Personagem{
    int Def, MagicDef, atqF, atqMag;
    private final Comportamentos comp;
    protected TiposElementais tipoDano;
    public Inimigo(String Nome, String Imagem, int fr, int in, int rs, int vel, int ModDef, int ModMagDef, int ModAtqF, int ModAtqM, int ModHp, int ModMp, TiposElementais tipoDn, Comportamentos comp) {
        super(Nome, Imagem, fr, in, rs, vel);
        this.Def += rs + ModDef;
        this.MagicDef += in + ModMagDef;
        this.atqF = ModAtqF;
        this.atqMag = ModAtqM;
        this.HP += ModHp;
        this.MP += ModMp;
        this.fraquezas = new TiposElementais[0];
        this.resistencias = new TiposElementais[0];
        this.imunidades = new TiposElementais[0];
        this.absorcao = new TiposElementais[0];
        this.tipoDano = tipoDn;
        this.comp = comp;
    }
    protected TiposElementais[] fraquezas;
    protected TiposElementais[] resistencias;
    protected TiposElementais[] imunidades;
    protected TiposElementais[] absorcao;

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

    public Comportamentos getComp() {
        return comp;
    }
}
