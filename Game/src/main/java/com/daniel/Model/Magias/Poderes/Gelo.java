package com.daniel.Model.Magias.Poderes;

import com.daniel.Model.Magias.Animacoes.IceAnimation;
import com.daniel.Model.Magias.Magia;
import com.daniel.Model.Magias.TiposElementais;

public class Gelo extends Magia {
    public Gelo() {
        super("Glacies",10, 1, TiposElementais.Gelo, new IceAnimation(), true);
    }
}