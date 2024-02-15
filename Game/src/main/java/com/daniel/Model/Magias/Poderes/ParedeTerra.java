package com.daniel.Model.Magias.Poderes;

import com.daniel.Model.Magias.Animacoes.ParedeTerraAnimation;
import com.daniel.Model.Magias.Magia;
import com.daniel.Model.Magias.TiposElementais;

public class ParedeTerra extends Magia {
    public ParedeTerra() {
        super("Magnus lapis", 20, 2, TiposElementais.Terra,new ParedeTerraAnimation(), true);
    }
}
