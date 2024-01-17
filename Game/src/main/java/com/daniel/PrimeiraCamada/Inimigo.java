package com.daniel.PrimeiraCamada;

public abstract class Inimigo extends Personagem{
    int Def, MagicDef, atqF, atqMag, pos,  dropXp;
    private final Comportamentos comp;
    protected TiposElementais tipoDano;
    public Inimigo(String Nome, String Imagem, int posicao, int fr, int in, int rs, int vel, int ModDef, int ModMagDef, int ModAtqF, int ModAtqM, int ModHp, int ModMp, TiposElementais tipoDn, Comportamentos comp, int dropXp) {
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
        this.pos = posicao;
        this.dropXp = dropXp;
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

    public int getDropXp() {
        return dropXp;
    }

    public int getPos(){return pos;}

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
