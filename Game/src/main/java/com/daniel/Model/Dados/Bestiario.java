package com.daniel.Model.Dados;

import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;

import java.io.Serializable;

public class Bestiario implements Serializable {
    private Inimigo[] inimigosConhecidos = new Inimigo[40];

    public Inimigo[] getInimigos(){
        return inimigosConhecidos;
    }
    public void adicionarInimigos(Inimigo i){
        if(inimigosConhecidos[i.getPos()-1] == null){
            inimigosConhecidos[i.getPos()-1] = i;
        }
    }
}
