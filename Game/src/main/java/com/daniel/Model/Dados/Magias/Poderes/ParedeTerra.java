package com.daniel.Model.Dados.Magias.Poderes;

import com.daniel.Model.Dados.Magias.Animation.ParedeTerraAnimation;
import com.daniel.Model.Dados.Magias.Magia;
import com.daniel.Model.Dados.Magias.TiposElementais;

public class ParedeTerra extends Magia {
    public ParedeTerra() {
        super("Magnus lapis", 20, 2, TiposElementais.Terra,new ParedeTerraAnimation(), true);
    }
}
