package com.daniel.Model.Magias.Poderes;

import com.daniel.Model.Magias.Animation.TerraAnimation;
import com.daniel.Model.Magias.Magia;
import com.daniel.Model.Magias.TiposElementais;

public class Terra extends Magia {
    public Terra() {
        super("Lapillus", 10, 1, TiposElementais.Terra,new TerraAnimation(), true);
    }
}
