package com.daniel.Modelo.Magia.Poderes;

import com.daniel.Dados.MagiasRepositório.TerraAnimation;
import com.daniel.Modelo.Magia.Magia;
import com.daniel.Modelo.Magia.TiposElementais;

public class Terra extends Magia {
    public Terra() {
        super("Lapillus", 10, 1, TiposElementais.Terra,new TerraAnimation(), true);
    }
}
