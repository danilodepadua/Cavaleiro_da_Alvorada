package com.daniel.SegundaCamada;

import com.daniel.PrimeiraCamada.Inimigo;

import java.io.Serializable;

public class Bestiario implements Serializable {
    private Inimigo[] inimigosConhecidos = new Inimigo[36];

    public Inimigo[] getInimigos(){
        return inimigosConhecidos;
    }
    public void adicionarInimigos(Inimigo i){
        if(inimigosConhecidos[i.getPos()] != null){
            inimigosConhecidos[i.getPos()] = i;
        }
    }
}
