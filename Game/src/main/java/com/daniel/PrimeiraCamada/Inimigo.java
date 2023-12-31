package com.daniel.PrimeiraCamada;

public abstract class Inimigo extends Personagem{
    int Def, MagicDef, atqF, atqMag;
    public Inimigo(String Nome, String Imagem, int fr, int in, int rs, int vel, int ModDef, int ModMagDef, int ModAtqF, int ModAtqM, int ModHp, int ModMp, TiposDano[] fra, TiposDano[] res, TiposDano[] imu, TiposDano[] abs) {
        super(Nome, Imagem, fr, in, rs, vel);
        this.Def += ModDef;
        this.MagicDef += super.getInteligence() + ModMagDef;
        this.atqF = this.getForce() + ModAtqF;
        this.atqMag = this.getInteligence() + ModAtqM;
        this.HP += ModHp;
        this.MP += ModMp;
        this.fraquezas = fra;
        this.resistencias = res;
        this.imunidades = imu;
        this.absorcao = abs;


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
