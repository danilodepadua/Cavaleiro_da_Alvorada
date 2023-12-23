package com.daniel.PrimeiraCamada.Save;


import com.daniel.PrimeiraCamada.Entidades.Player;

import java.io.Serializable;

public class Save implements Serializable {
    public Save(Player playerAtual){
        player = playerAtual;
    }
    protected Player player;
}
