package com.daniel.PrimeiraCamada;

import javafx.animation.Timeline;

public class Magia {
    protected int dano;
    protected TiposDano tiposDano;
    protected Timeline timeline;
    protected GerenciadorDeBatalha gerenciadorDeBatalha;

    public TiposDano getTiposDano() {
        return tiposDano;
    }

    public Timeline getTimeline() {
        return timeline;
    }


    public int getDano() {
        return dano;
    }

}
