package com.daniel.Model.Dados.Magias.Poderes;

import com.daniel.Model.Dados.Magias.Animation.TerraAnimation;
import com.daniel.Model.Dados.Magias.Magia;
import com.daniel.Model.Dados.Magias.TiposElementais;

public class Terra extends Magia {
    public Terra() {
        super("Lapillus", 10, 1, TiposElementais.Terra,new TerraAnimation(), true);
    }
}
