package com.daniel.Modelo.Magia.Poderes;

import com.daniel.Dados.MagiasRepositório.IceAnimation;
import com.daniel.Modelo.Magia.Magia;
import com.daniel.Modelo.Magia.TiposElementais;

public class Gelo extends Magia {
    public Gelo() {
        super("Glacies",10, 1, TiposElementais.Gelo, new IceAnimation(), true);
    }
}