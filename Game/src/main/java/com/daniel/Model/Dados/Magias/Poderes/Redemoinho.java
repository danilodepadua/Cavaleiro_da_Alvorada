package com.daniel.Model.Dados.Magias.Poderes;

import com.daniel.Model.Dados.Magias.Animation.RedemoinhoAnimation;
import com.daniel.Model.Dados.Magias.Magia;
import com.daniel.Model.Dados.Magias.TiposElementais;

public class Redemoinho extends Magia {
    public Redemoinho() {
        super("Magna aqua", 20, 2, TiposElementais.Gelo, new RedemoinhoAnimation(), true);
    }
}
