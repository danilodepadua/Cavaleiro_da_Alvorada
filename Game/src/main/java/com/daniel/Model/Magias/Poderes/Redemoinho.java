package com.daniel.Model.Magias.Poderes;

import com.daniel.Model.Magias.Animacoes.RedemoinhoAnimation;
import com.daniel.Model.Magias.Magia;
import com.daniel.Model.Magias.TiposElementais;

public class Redemoinho extends Magia {
    public Redemoinho() {
        super("Magna aqua", 20, 2, TiposElementais.Gelo, new RedemoinhoAnimation(), true);
    }
}
