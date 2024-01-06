package com.daniel.PrimeiraCamada;

import com.daniel.SegundaCamada.AnimationsAttack;
import javafx.animation.Timeline;

public abstract class Magia {
    protected int custo;
    protected TiposDano tiposDano;
    protected AnimationsAttack Animation;

    public TiposDano getTiposDano() {
        return tiposDano;
    }

    public AnimationsAttack getAnimation() {
        return Animation;
    }
    public int getCusto(){return custo;}
}
