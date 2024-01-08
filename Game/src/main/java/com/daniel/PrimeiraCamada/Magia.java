package com.daniel.PrimeiraCamada;

import com.daniel.SegundaCamada.AnimationsAttack;
import javafx.animation.Timeline;

public abstract class Magia {
    protected int custo;
    protected double multiplicador;
    protected TiposDano tiposDano;
    protected AnimationsAttack Animation;

    public Magia(int custo, double multiplicador, TiposDano tiposDano, AnimationsAttack animation) {
        this.custo = custo;
        this.multiplicador = multiplicador;
        this.tiposDano = tiposDano;
        this.Animation = animation;
    }

    public TiposDano getTiposDano() {
        return tiposDano;
    }

    public AnimationsAttack getAnimation() {
        return Animation;
    }
    public int getCusto(){return custo;}
    public double getMultiplicador(){return multiplicador;}
}
