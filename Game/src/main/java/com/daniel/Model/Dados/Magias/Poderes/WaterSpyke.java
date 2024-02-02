package com.daniel.Model.Dados.Magias.Poderes;

import com.daniel.Model.Dados.Magias.Animation.WaterSpykeAnimation;
import com.daniel.Model.Dados.Magias.Magia;
import com.daniel.Model.Dados.Magias.TiposElementais;

public class WaterSpyke extends Magia {
    public WaterSpyke() {
        super("Aqua", 15, 1.5, TiposElementais.Gelo, new WaterSpykeAnimation(), true);
    }
}
