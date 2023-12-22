package com.daniel.Basicos;

import java.io.Serializable;

public class Save implements Serializable {
    public Save(Player playerAtual){
        player = playerAtual;
    }
    protected Player player;
}
