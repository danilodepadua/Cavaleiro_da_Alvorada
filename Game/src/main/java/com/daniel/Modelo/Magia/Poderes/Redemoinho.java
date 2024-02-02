package com.daniel.Modelo.Magia.Poderes;

import com.daniel.Dados.MagiasRepositório.RedemoinhoAnimation;
import com.daniel.Modelo.Magia.Magia;
import com.daniel.Modelo.Magia.TiposElementais;

public class Redemoinho extends Magia {
    public Redemoinho() {
        super("Magna aqua", 20, 2, TiposElementais.Gelo, new RedemoinhoAnimation(), true);
    }
}
