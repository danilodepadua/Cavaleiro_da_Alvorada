package com.daniel.Modelo.Magia.Poderes;

import com.daniel.Dados.MagiasRepositório.BolaRaioAnimation;
import com.daniel.Modelo.Magia.Magia;
import com.daniel.Modelo.Magia.TiposElementais;

public class ThunderBall extends Magia {
    public ThunderBall() {
        super("Parvum radii", 10, 1, TiposElementais.Eletrico, new BolaRaioAnimation(), true);
    }
}
