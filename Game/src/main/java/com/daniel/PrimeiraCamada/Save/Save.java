package com.daniel.PrimeiraCamada.Save;


import com.daniel.PrimeiraCamada.Cidade;
import com.daniel.PrimeiraCamada.Entidades.Player;

import java.io.Serializable;

public class Save implements Serializable {
    public Save(Player playerAtual, Cidade cidadeAtual){
        player = playerAtual;
        cidade = cidadeAtual;
    }
    protected Player player;
    protected Cidade cidade;
}
