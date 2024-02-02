package com.daniel.Model.Magias.Poderes;

import com.daniel.Model.Magias.Animation.WaterSpykeAnimation;
import com.daniel.Model.Magias.Magia;
import com.daniel.Model.Magias.TiposElementais;

public class WaterSpyke extends Magia {
    public WaterSpyke() {
        super("Aqua", 15, 1.5, TiposElementais.Gelo, new WaterSpykeAnimation(), true);
    }
}
