package com.daniel.Modelo.Save;


import com.daniel.Dados.CidadeRepositório.Cidade;
import com.daniel.Dados.EntidadesRepositório.Player;

import java.io.Serializable;

public class Save implements Serializable {
    public Save(Player playerAtual, Cidade cidadeAtual){
        player = playerAtual;
        cidade = cidadeAtual;
    }
    protected Player player;
    protected Cidade cidade;
}
