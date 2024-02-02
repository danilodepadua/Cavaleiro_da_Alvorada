package com.daniel.Model.Dados.Magias.Poderes;

import com.daniel.Model.Dados.Magias.Animation.IceAnimation;
import com.daniel.Model.Dados.Magias.Magia;
import com.daniel.Model.Dados.Magias.TiposElementais;

public class Gelo extends Magia {
    public Gelo() {
        super("Glacies",10, 1, TiposElementais.Gelo, new IceAnimation(), true);
    }
}