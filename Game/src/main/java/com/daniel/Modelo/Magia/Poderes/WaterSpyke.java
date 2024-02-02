package com.daniel.Modelo.Magia.Poderes;

import com.daniel.Dados.MagiasRepositório.WaterSpykeAnimation;
import com.daniel.Modelo.Magia.Magia;
import com.daniel.Modelo.Magia.TiposElementais;

public class WaterSpyke extends Magia {
    public WaterSpyke() {
        super("Aqua", 15, 1.5, TiposElementais.Gelo, new WaterSpykeAnimation(), true);
    }
}
