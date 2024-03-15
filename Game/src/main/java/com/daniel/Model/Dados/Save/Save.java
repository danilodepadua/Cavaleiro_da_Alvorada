package com.daniel.Model.Dados.Save;


import com.daniel.Model.Dados.Cidades.Cidade;
import com.daniel.Model.Dados.Entidades.Player;

import java.io.Serializable;

public class Save implements Serializable {
    public Save(Player playerAtual, Cidade cidadeAtual){
        player = playerAtual;
        cidade = cidadeAtual;
    }
    protected Player player;
    protected Cidade cidade;

    public Player getPlayer(){
        return player;
    }
    public Cidade getCidade(){
        return cidade;
    }
}
