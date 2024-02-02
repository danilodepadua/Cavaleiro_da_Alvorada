package com.daniel.Modelo.Magia.Poderes;

import com.daniel.Dados.MagiasRepositório.ParedeTerraAnimation;
import com.daniel.Modelo.Magia.Magia;
import com.daniel.Modelo.Magia.TiposElementais;

public class ParedeTerra extends Magia {
    public ParedeTerra() {
        super("Magnus lapis", 20, 2, TiposElementais.Terra,new ParedeTerraAnimation(), true);
    }
}
